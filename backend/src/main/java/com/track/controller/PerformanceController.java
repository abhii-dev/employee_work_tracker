package com.track.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.track.dto.PerformanceResponseDto;
import com.track.service.PerformanceService;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {

    private final PerformanceService performanceService;

    public PerformanceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @GetMapping("/employee/{employeeId}")
    public PerformanceResponseDto getEmployeePerformance(
            @PathVariable Long employeeId) {

        return performanceService.getEmployeePerformance(employeeId);
    }

    @GetMapping("/all")
    public List<PerformanceResponseDto> getAllPerformance() {

        return performanceService.getAllPerformance();
    }
}