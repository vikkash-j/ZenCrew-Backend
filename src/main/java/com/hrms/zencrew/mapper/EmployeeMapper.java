package com.hrms.zencrew.mapper;

import org.springframework.stereotype.Component;

import com.hrms.zencrew.dto.response.EmployeeResponseDto;
import com.hrms.zencrew.entity.Employee;

@Component
public class EmployeeMapper {
	
	public EmployeeResponseDto toResponseDto(Employee employee) {
		
		EmployeeResponseDto dto = new EmployeeResponseDto();
		
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setAge(employee.getAge());
		dto.setEmail(employee.getEmail());
		dto.setPhone(employee.getPhone());
		dto.setAddress(employee.getAddress());
		
		if(employee.getDepartment() != null) {
			dto.setDepartmentName(employee.getDepartment().getDepartmentName());
		}
		return dto;
	}

}
