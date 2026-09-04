package com.hrms.zencrew.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.hrms.zencrew.dto.request.LoginRequestDto;
import com.hrms.zencrew.dto.response.LoginResponseDto;
import com.hrms.zencrew.entity.Employee;
import com.hrms.zencrew.repository.EmployeeRepository;
import com.hrms.zencrew.security.JwtService;
import com.hrms.zencrew.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private final AuthenticationManager authenticationManager;
	private final EmployeeRepository employeeRepository;
	private final JwtService jwtService;

	public AuthenticationServiceImpl(AuthenticationManager authenticationManager, EmployeeRepository employeeRepository,
			JwtService jwtService) {
		super();
		this.authenticationManager = authenticationManager;
		this.employeeRepository = employeeRepository;
		this.jwtService = jwtService;
	}

	@Override
	public LoginResponseDto login(LoginRequestDto loginRequest) {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		Employee employee = employeeRepository.findByEmail(loginRequest.getEmail())
				.orElseThrow(() -> new RuntimeException("Employee not found"));

		String token = jwtService.generateToken(employee);

		return new LoginResponseDto(token, employee.getEmail(), employee.getRole());
	}

}
