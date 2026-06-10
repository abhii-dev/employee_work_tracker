package com.track.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.track.dto.LoginRequest;
import com.track.dto.LoginResponse;
import com.track.dto.RegisterRequest;
import com.track.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthContoller {
	
	private AuthService authService;
	
	public AuthContoller(AuthService authService) {
		this.authService = authService;
		
	}
	
	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest request) {
		return authService.register(request);
	}
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		return authService.login(request);
	}

}
