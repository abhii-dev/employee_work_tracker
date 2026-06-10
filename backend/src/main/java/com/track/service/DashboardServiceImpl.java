package com.track.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.track.dto.AdminDashboardResponseDto;
import com.track.dto.EmployeeDashboardResponseDto;
import com.track.dto.PerformanceResponseDto;
import com.track.entity.Employee;
import com.track.enums.TaskStatus;
import com.track.repository.EmployeeRepository;
import com.track.repository.ManagerRepository;
import com.track.repository.TaskRepository;
import com.track.dto.ManagerDashboardResponseDto;
import com.track.entity.Manager;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;
    private final TaskRepository taskRepository;
    private final PerformanceService performanceService;

    public DashboardServiceImpl(
            EmployeeRepository employeeRepository,
            ManagerRepository managerRepository,
            TaskRepository taskRepository,
            PerformanceService performanceService) {

        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
        this.taskRepository = taskRepository;
        this.performanceService = performanceService;
    }

    @Override
    public AdminDashboardResponseDto getAdminDashboard() {

        AdminDashboardResponseDto response =
                new AdminDashboardResponseDto();

        long totalEmployees = employeeRepository.count();

        long totalManagers = managerRepository.count();

        long totalTasks = taskRepository.count();

        long completedTasks =
                taskRepository.countByStatus(
                        TaskStatus.COMPLETED
                );

        long pendingTasks =
                taskRepository.countByStatus(
                        TaskStatus.PENDING
                );

        List<PerformanceResponseDto> performances =
                performanceService.getAllPerformance();

        double averagePerformanceScore =
                performances.stream()
                        .mapToDouble(
                                PerformanceResponseDto::getFinalScore
                        )
                        .average()
                        .orElse(0);

        String topPerformer = "No Employees";

        double highestScore = 0;

        for (PerformanceResponseDto performance : performances) {

            if (performance.getFinalScore() > highestScore) {

                highestScore =
                        performance.getFinalScore();

                topPerformer =
                        performance.getEmployeeName();
            }
        }

        response.setTotalEmployees(totalEmployees);
        response.setTotalManagers(totalManagers);
        response.setTotalTasks(totalTasks);
        response.setCompletedTasks(completedTasks);
        response.setPendingTasks(pendingTasks);
        response.setAveragePerformanceScore(
                averagePerformanceScore
        );
        response.setTopPerformer(topPerformer);

        return response;
    }
    
    
    
    
    //employee
    
    @Override
    public EmployeeDashboardResponseDto getEmployeeDashboard(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));

        long assignedTasks =
                taskRepository.countByEmployeeId(employeeId);

        long completedTasks =
                taskRepository.countByEmployeeIdAndStatus(
                        employeeId,
                        TaskStatus.COMPLETED
                );

        PerformanceResponseDto performance =
                performanceService.getEmployeePerformance(employeeId);

        EmployeeDashboardResponseDto response =
                new EmployeeDashboardResponseDto();

        response.setEmployeeId(employee.getId());

        response.setEmployeeName(
                employee.getFirstName()
                        + " "
                        + employee.getLastName()
        );

        response.setAssignedTasks(assignedTasks);

        response.setCompletedTasks(completedTasks);

        response.setAttendanceScore(
                performance.getAttendanceScore()
        );

        response.setReviewScore(
                performance.getReviewScore()
        );

        response.setPerformanceScore(
                performance.getFinalScore()
        );

        return response;
    }
    
    
    
    
    
    @Override
    public ManagerDashboardResponseDto getManagerDashboard(Long managerId) {

        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() ->
                        new RuntimeException("Manager not found"));

        long teamSize = manager.getEmployees().size();

        long tasksAssigned =
                taskRepository.countByManagerId(managerId);

        long completedTasks =
                taskRepository.countByManagerIdAndStatus(
                        managerId,
                        TaskStatus.COMPLETED
                );

        double averageTeamPerformance = 0;

        double highestScore = 0;

        String topPerformer = "No Employees";

        if (!manager.getEmployees().isEmpty()) {

            double totalScore = 0;

            for (Employee employee : manager.getEmployees()) {

                PerformanceResponseDto performance =
                        performanceService.getEmployeePerformance(
                                employee.getId()
                        );

                totalScore += performance.getFinalScore();

                if (performance.getFinalScore() > highestScore) {

                    highestScore = performance.getFinalScore();

                    topPerformer =
                            employee.getFirstName()
                                    + " "
                                    + employee.getLastName();
                }
            }

            averageTeamPerformance =
                    totalScore / manager.getEmployees().size();
        }

        ManagerDashboardResponseDto response =
                new ManagerDashboardResponseDto();

        response.setManagerId(manager.getId());

        response.setManagerName(
                manager.getFirstName()
                        + " "
                        + manager.getLastName()
        );

        response.setTeamSize(teamSize);

        response.setTasksAssigned(tasksAssigned);

        response.setCompletedTasks(completedTasks);

        response.setAverageTeamPerformance(
                averageTeamPerformance
        );

        response.setTopPerformer(topPerformer);

        return response;
    }
    
    
    
    
    
    
}