package com.track.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.track.dto.LeaveRequestDto;
import com.track.dto.LeaveResponseDto;
import com.track.service.LeaveService;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("/apply")
    public LeaveResponseDto applyLeave(
            @RequestBody LeaveRequestDto requestDto) {

        return leaveService.applyLeave(requestDto);
    }

    @PutMapping("/{leaveId}/approve")
    public LeaveResponseDto approveLeave(
            @PathVariable Long leaveId) {

        return leaveService.approveLeave(leaveId);
    }

    @PutMapping("/{leaveId}/reject")
    public LeaveResponseDto rejectLeave(
            @PathVariable Long leaveId) {

        return leaveService.rejectLeave(leaveId);
    }

    @GetMapping("/employee/{employeeId}")
    public List<LeaveResponseDto> getEmployeeLeaves(
            @PathVariable Long employeeId) {

        return leaveService.getEmployeeLeaves(employeeId);
    }

    @GetMapping("/all")
    public List<LeaveResponseDto> getAllLeaves() {

        return leaveService.getAllLeaves();
    }
}