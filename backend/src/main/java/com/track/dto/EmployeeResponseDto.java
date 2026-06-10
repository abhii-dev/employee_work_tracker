package com.track.dto;

public class EmployeeResponseDto {

    private Long id;
    private String employeeCode;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String designation;
    private Long managerId;
    private String managerName;


    public EmployeeResponseDto() {
    }

    public EmployeeResponseDto(Long id,String employeeCode,String firstName,String lastName,String email,String department,String designation, Long managerId, String managerName) {
    	this.id = id;
        this.employeeCode = employeeCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.managerId = managerId;
        this.managerName = managerName;
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
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