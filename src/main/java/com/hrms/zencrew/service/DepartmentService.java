package com.hrms.zencrew.service;

import java.util.List;

import com.hrms.zencrew.dto.request.DepartmentRequestDto;
import com.hrms.zencrew.dto.response.DepartmentResponseDto;

public interface DepartmentService {
	
	DepartmentResponseDto createDepartment(DepartmentRequestDto dto);
	
	List<DepartmentResponseDto> getAllDepartments();
	
	DepartmentResponseDto getDepartmentById(Long id);
	
	DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto dto);
	
	void deleteDepartment(Long id);
	
	

}
