package com.track.dto;

import com.track.enums.AttendanceStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AttendanceResponseDto {

    private Long id;

    private Long employeeId;

    private String employeeName;

    private LocalDate attendanceDate;

    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    private AttendanceStatus status;

    public AttendanceResponseDto() {
    }

    public AttendanceResponseDto(Long id,
                                 Long employeeId,
                                 String employeeName,
                                 LocalDate attendanceDate,
                                 LocalDateTime checkInTime,
                                 LocalDateTime checkOutTime,
                                 AttendanceStatus status) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.attendanceDate = attendanceDate;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }
}