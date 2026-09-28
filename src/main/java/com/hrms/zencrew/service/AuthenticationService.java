package com.hrms.zencrew.service;

import com.hrms.zencrew.dto.request.LoginRequestDto;
import com.hrms.zencrew.dto.response.EmployeeResponseDto;
import com.hrms.zencrew.dto.response.LoginResponseDto;

public interface AuthenticationService {
	
	LoginResponseDto login(LoginRequestDto loginRequest);
	
	EmployeeResponseDto getCurrentEmployee(String email);

}
