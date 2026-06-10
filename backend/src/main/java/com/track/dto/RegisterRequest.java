package com.track.dto;

import com.track.enums.Role;

public class RegisterRequest {
	private String name;
	private String email;
	private String password;
	private Role role;
	
	public RegisterRequest() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passowrd) {
		this.password = passowrd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
