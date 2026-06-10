package com.track.dto;

import java.time.LocalDate;

public class ReviewResponseDto {

    private Long id;

    private Integer rating;

    private String comments;

    private LocalDate reviewDate;

    private Long employeeId;

    private String employeeName;

    private Long managerId;

    private String managerName;

    public ReviewResponseDto() {
    }

	public ReviewResponseDto(Long id, Integer rating, String comments, LocalDate reviewDate, Long employeeId,
			String employeeName, Long managerId, String managerName) {
		super();
		this.id = id;
		this.rating = rating;
		this.comments = comments;
		this.reviewDate = reviewDate;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.managerId = managerId;
		this.managerName = managerName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

    
	
}