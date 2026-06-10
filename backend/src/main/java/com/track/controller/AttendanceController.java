package com.track.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.track.dto.AttendanceResponseDto;
import com.track.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(
            AttendanceService attendanceService) {

        this.attendanceService = attendanceService;
    }

    @PostMapping("/checkin/{employeeId}")
    public ResponseEntity<AttendanceResponseDto> checkIn(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(
                attendanceService.checkIn(employeeId));
    }

    @PostMapping("/checkout/{employeeId}")
    public ResponseEntity<AttendanceResponseDto> checkOut(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(
                attendanceService.checkOut(employeeId));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<AttendanceResponseDto>>
    getAttendanceByEmployee(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(
                attendanceService.getAttendanceByEmployee(employeeId));
    }

    @GetMapping("/today/{employeeId}")
    public ResponseEntity<AttendanceResponseDto>
    getTodayAttendance(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(
                attendanceService.getTodayAttendance(employeeId));
    }
}