package com.track.service;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.track.dto.AttendanceResponseDto;
import com.track.entity.Attendance;
import com.track.entity.Employee;
import com.track.enums.AttendanceStatus;
import com.track.repository.AttendanceRepository;
import com.track.repository.EmployeeRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    public AttendanceServiceImpl(
            AttendanceRepository attendanceRepository,
            EmployeeRepository employeeRepository) {

        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public AttendanceResponseDto checkIn(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));

        attendanceRepository
                .findByEmployeeIdAndAttendanceDate(
                        employeeId,
                        LocalDate.now())
                .ifPresent(attendance -> {
                    throw new RuntimeException(
                            "Attendance already marked today");
                });

        Attendance attendance = new Attendance();

        attendance.setEmployee(employee);
        attendance.setAttendanceDate(LocalDate.now());
        attendance.setCheckInTime(LocalDateTime.now());
        attendance.setStatus(AttendanceStatus.PRESENT);

        Attendance savedAttendance =
                attendanceRepository.save(attendance);

        return mapToDto(savedAttendance);
    }

    @Override
    public AttendanceResponseDto checkOut(Long employeeId) {

        Attendance attendance =
                attendanceRepository
                        .findByEmployeeIdAndAttendanceDate(
                                employeeId,
                                LocalDate.now())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Please check in first"));

        if (attendance.getCheckOutTime() != null) {
            throw new RuntimeException(
                    "Already checked out");
        }

        attendance.setCheckOutTime(LocalDateTime.now());

        Attendance updatedAttendance =
                attendanceRepository.save(attendance);

        return mapToDto(updatedAttendance);
    }

    @Override
    public List<AttendanceResponseDto> getAttendanceByEmployee(
            Long employeeId) {

        return attendanceRepository
                .findByEmployeeId(employeeId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceResponseDto getTodayAttendance(
            Long employeeId) {

        Attendance attendance =
                attendanceRepository
                        .findByEmployeeIdAndAttendanceDate(
                                employeeId,
                                LocalDate.now())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Attendance not found"));

        return mapToDto(attendance);
    }

    private AttendanceResponseDto mapToDto(
            Attendance attendance) {

        AttendanceResponseDto dto =
                new AttendanceResponseDto();

        dto.setId(attendance.getId());

        dto.setEmployeeId(
                attendance.getEmployee().getId());

        dto.setEmployeeName(
                attendance.getEmployee().getFirstName()
                        + " "
                        + attendance.getEmployee().getLastName());

        dto.setAttendanceDate(
                attendance.getAttendanceDate());

        dto.setCheckInTime(
                attendance.getCheckInTime());

        dto.setCheckOutTime(
                attendance.getCheckOutTime());

        dto.setStatus(
                attendance.getStatus());

        return dto;
    }
}