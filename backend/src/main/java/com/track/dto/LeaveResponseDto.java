package com.track.dto;

import java.time.LocalDate;

public class LeaveResponseDto {

    private Long leaveId;

    private String employeeName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private String status;

    public LeaveResponseDto() {
    }

	public LeaveResponseDto(Long leaveId, String employeeName, LocalDate startDate, LocalDate endDate, String reason,
			String status) {
		super();
		this.leaveId = leaveId;
		this.employeeName = employeeName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
	}

	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}