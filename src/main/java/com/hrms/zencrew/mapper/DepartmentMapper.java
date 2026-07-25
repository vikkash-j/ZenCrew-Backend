package com.hrms.zencrew.mapper;

import org.springframework.stereotype.Component;

import com.hrms.zencrew.dto.request.DepartmentRequestDto;
import com.hrms.zencrew.dto.response.DepartmentResponseDto;
import com.hrms.zencrew.entity.Department;

@Component
public class DepartmentMapper {
	
	public Department toEntity(DepartmentRequestDto dto) {
		
		Department department = new Department();
		
		department.setDepartmentName(dto.getDepartmentName());
		department.setLocation(dto.getLocation());
		
		return department;
		
	}
	
	public DepartmentResponseDto toResponseDto(Department department) {
		
		 DepartmentResponseDto dto = new DepartmentResponseDto();
		 
		 dto.setId(department.getId());
		 dto.setDepartmentName(department.getDepartmentName());
		 dto.setLocation(department.getLocation());
		 
		 return dto;
		 
	}
}
