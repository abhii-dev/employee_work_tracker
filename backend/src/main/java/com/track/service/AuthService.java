package com.track.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.track.dto.LoginRequest;
import com.track.dto.LoginResponse;
import com.track.dto.RegisterRequest;
import com.track.entity.User;
import com.track.repository.UserRepository;
import com.track.security.JwtService;

@Service
public class AuthService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtService jwtService;
	
	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}
	
	public String register(RegisterRequest request) {
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {
			return "User Already exists";
		}
		
		User user = new User();
		
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		user.setRole(request.getRole());
		
		userRepository.save(user);
		
		
		return "User Registerd Succesfully";
		
		
	}
	
	public LoginResponse login(LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail()).orElse(null);
		
		if(user == null) {
			throw new RuntimeException("User not found");
		}
		
		boolean match = passwordEncoder.matches(request.getPassword(), user.getPassword());
		
		if(!match) {
			throw new RuntimeException("Invalid Password");
		}
		
		String token = jwtService.generateToken(user.getEmail(), user.getRole().name());
		
		return new LoginResponse(token, user.getRole().name());
		
		
	}
	
	
	
	

}
