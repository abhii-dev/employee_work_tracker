package com.track.service;

import java.util.List;

import com.track.dto.AttendanceResponseDto;

public interface AttendanceService {

    AttendanceResponseDto checkIn(Long employeeId);

    AttendanceResponseDto checkOut(Long employeeId);

    List<AttendanceResponseDto> getAttendanceByEmployee(Long employeeId);

    AttendanceResponseDto getTodayAttendance(Long employeeId);
}




