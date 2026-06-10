package com.track.service;

import com.track.dto.AdminDashboardResponseDto;
import com.track.dto.EmployeeDashboardResponseDto;
import com.track.dto.ManagerDashboardResponseDto;

public interface DashboardService {

    AdminDashboardResponseDto getAdminDashboard();
    
    EmployeeDashboardResponseDto getEmployeeDashboard(Long employeeId);
    
    ManagerDashboardResponseDto getManagerDashboard(Long managerId);
}