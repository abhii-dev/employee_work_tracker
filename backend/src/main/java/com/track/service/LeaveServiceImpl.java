package com.track.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.track.dto.LeaveRequestDto;
import com.track.dto.LeaveResponseDto;
import com.track.entity.Employee;
import com.track.entity.LeaveRequest;
import com.track.enums.LeaveStatus;
import com.track.repository.EmployeeRepository;
import com.track.repository.LeaveRequestRepository;
import com.track.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRequestRepository leaveRepository;
    private final EmployeeRepository employeeRepository;

    public LeaveServiceImpl(
            LeaveRequestRepository leaveRepository,
            EmployeeRepository employeeRepository) {

        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public LeaveResponseDto applyLeave(
            LeaveRequestDto requestDto) {

        Employee employee = employeeRepository
                .findById(requestDto.getEmployeeId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Employee not found"));

        LeaveRequest leave = new LeaveRequest();

        leave.setEmployee(employee);
        leave.setStartDate(requestDto.getStartDate());
        leave.setEndDate(requestDto.getEndDate());
        leave.setReason(requestDto.getReason());

        leave.setAppliedDate(LocalDate.now());

        leave.setStatus(LeaveStatus.PENDING);

        LeaveRequest savedLeave =
                leaveRepository.save(leave);

        return mapToDto(savedLeave);
    }

    @Override
    public LeaveResponseDto approveLeave(
            Long leaveId) {

        LeaveRequest leave =
                leaveRepository.findById(leaveId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Leave request not found"));

        leave.setStatus(LeaveStatus.APPROVED);

        LeaveRequest updatedLeave =
                leaveRepository.save(leave);

        return mapToDto(updatedLeave);
    }

    @Override
    public LeaveResponseDto rejectLeave(
            Long leaveId) {

        LeaveRequest leave =
                leaveRepository.findById(leaveId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Leave request not found"));

        leave.setStatus(LeaveStatus.REJECTED);

        LeaveRequest updatedLeave =
                leaveRepository.save(leave);

        return mapToDto(updatedLeave);
    }

    @Override
    public List<LeaveResponseDto> getEmployeeLeaves(
            Long employeeId) {

        return leaveRepository
                .findByEmployeeId(employeeId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LeaveResponseDto> getAllLeaves() {

        return leaveRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private LeaveResponseDto mapToDto(
            LeaveRequest leave) {

        LeaveResponseDto dto =
                new LeaveResponseDto();

        dto.setLeaveId(leave.getId());

        dto.setEmployeeName(
                leave.getEmployee().getFirstName()
                        + " "
                        + leave.getEmployee().getLastName());

        dto.setStartDate(
                leave.getStartDate());

        dto.setEndDate(
                leave.getEndDate());

        dto.setReason(
                leave.getReason());

        dto.setStatus(
                leave.getStatus().name());

        return dto;
    }
}
