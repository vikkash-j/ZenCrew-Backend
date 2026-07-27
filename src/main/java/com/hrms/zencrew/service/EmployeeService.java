package com.hrms.zencrew.service;

import java.util.List;

import com.hrms.zencrew.dto.request.EmployeeRequestDto;
import com.hrms.zencrew.dto.response.EmployeeResponseDto;

public interface EmployeeService {
	
		EmployeeResponseDto createEmployee(EmployeeRequestDto dto);
		
		List<EmployeeResponseDto> getAllEmployee();
		
		EmployeeResponseDto getAllEmployeeById(Long Id);
		
		EmployeeResponseDto updateEmployee(Long Id, EmployeeRequestDto dto );
		
		void deleteEmployee(Long Id);
		
		
}
