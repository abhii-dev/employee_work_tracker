package com.track.dto;

public class ManagerResponseDto {

    private Long id;
    private String managerCode;
    private String firstName;
    private String lastName;
    private String email;
    private String department;

    public ManagerResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}