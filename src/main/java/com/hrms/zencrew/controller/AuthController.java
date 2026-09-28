package com.hrms.zencrew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.zencrew.dto.request.LoginRequestDto;
import com.hrms.zencrew.dto.response.EmployeeResponseDto;
import com.hrms.zencrew.dto.response.LoginResponseDto;
import com.hrms.zencrew.service.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequest) {

		LoginResponseDto response = authenticationService.login(loginRequest);

		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@GetMapping("/me")
	public ResponseEntity<EmployeeResponseDto> getCurrentEmployee(Authentication authentication) {

		String email = authentication.getName();

		EmployeeResponseDto response = authenticationService.getCurrentEmployee(email);

		return ResponseEntity.ok(response);
	}

}
