package com.track.dto;

public class AttendanceRequestDto {
	
	private Long employeeId;
	
	public AttendanceRequestDto() {
		
	}
	
	public AttendanceRequestDto(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
}
