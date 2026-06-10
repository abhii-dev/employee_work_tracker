package com.track.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.track.dto.AdminDashboardResponseDto;
import com.track.dto.EmployeeDashboardResponseDto;
import com.track.dto.ManagerDashboardResponseDto;
import com.track.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(
            DashboardService dashboardService) {

        this.dashboardService = dashboardService;
    }

    @GetMapping("/admin")
    public AdminDashboardResponseDto getAdminDashboard() {

        return dashboardService.getAdminDashboard();
    }
    
    
    
    @GetMapping("/employee/{employeeId}")
    public EmployeeDashboardResponseDto getEmployeeDashboard(
            @PathVariable Long employeeId) {

        return dashboardService.getEmployeeDashboard(employeeId);
    }
    
    
    @GetMapping("/manager/{managerId}")
    public ManagerDashboardResponseDto getManagerDashboard(
            @PathVariable Long managerId) {

        return dashboardService.getManagerDashboard(managerId);
    }
}