package com.track.service;

import java.util.List;

import com.track.dto.EmployeeRequestDto;
import com.track.dto.EmployeeResponseDto;

public interface EmployeeService {
	
	EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto);
	
	EmployeeResponseDto getEmployeeById(Long id);
	
	List<EmployeeResponseDto> getAllEmployees();
	
	EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto requestDto);
	
	void deleteEmployee(Long id);
	
	EmployeeResponseDto assignManager(
	        Long employeeId,
	        Long managerId
	);
	

}
