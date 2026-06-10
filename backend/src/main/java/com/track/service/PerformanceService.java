package com.track.service;

import com.track.dto.PerformanceResponseDto;

import java.util.List;

public interface PerformanceService {

    PerformanceResponseDto getEmployeePerformance(Long employeeId);

    List<PerformanceResponseDto> getAllPerformance();
}