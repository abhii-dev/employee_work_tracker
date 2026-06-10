package com.track.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.track.dto.PerformanceResponseDto;
import com.track.entity.Employee;
import com.track.entity.Review;
import com.track.enums.AttendanceStatus;
import com.track.enums.TaskStatus;
import com.track.repository.AttendanceRepository;
import com.track.repository.EmployeeRepository;
import com.track.repository.ReviewRepository;
import com.track.repository.TaskRepository;
import com.track.service.PerformanceService;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;
    private final AttendanceRepository attendanceRepository;
    private final ReviewRepository reviewRepository;

    public PerformanceServiceImpl(
            EmployeeRepository employeeRepository,
            TaskRepository taskRepository,
            AttendanceRepository attendanceRepository,
            ReviewRepository reviewRepository) {

        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
        this.attendanceRepository = attendanceRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public PerformanceResponseDto getEmployeePerformance(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));

        // TASK SCORE

        long totalTasks =
                taskRepository.countByEmployeeId(employeeId);

        long completedTasks =
                taskRepository.countByEmployeeIdAndStatus(
                        employeeId,
                        TaskStatus.COMPLETED
                );

        double taskScore = totalTasks == 0
                ? 0
                : ((double) completedTasks / totalTasks) * 100;

        // ATTENDANCE SCORE

        long totalAttendance =
                attendanceRepository.countByEmployeeId(employeeId);

        long presentAttendance =
                attendanceRepository.countByEmployeeIdAndStatus(
                        employeeId,
                        AttendanceStatus.PRESENT
                );

        double attendanceScore = totalAttendance == 0
                ? 0
                : ((double) presentAttendance / totalAttendance) * 100;

        // REVIEW SCORE

        List<Review> reviews =
                reviewRepository.findByEmployeeId(employeeId);

        double averageRating = reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0);

        double reviewScore = (averageRating / 5.0) * 100;

        // FINAL SCORE

        double finalScore =
                (taskScore * 0.40)
                        + (attendanceScore * 0.30)
                        + (reviewScore * 0.30);

        PerformanceResponseDto response =
                new PerformanceResponseDto();

        response.setEmployeeId(employee.getId());

        response.setEmployeeName(
                employee.getFirstName()
                        + " "
                        + employee.getLastName()
        );

        response.setTaskScore(taskScore);
        response.setAttendanceScore(attendanceScore);
        response.setReviewScore(reviewScore);
        response.setFinalScore(finalScore);

        return response;
    }

    @Override
    public List<PerformanceResponseDto> getAllPerformance() {

        List<Employee> employees =
                employeeRepository.findAll();

        List<PerformanceResponseDto> response =
                new ArrayList<>();

        for (Employee employee : employees) {

            response.add(
                    getEmployeePerformance(
                            employee.getId()
                    )
            );
        }

        return response;
    }
}