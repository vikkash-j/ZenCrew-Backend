package com.hrms.zencrew.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.zencrew.dto.request.EmployeeRequestDto;
import com.hrms.zencrew.dto.response.EmployeeResponseDto;
import com.hrms.zencrew.entity.Department;
import com.hrms.zencrew.entity.Employee;
import com.hrms.zencrew.exception.ResourceNotFoundException;
import com.hrms.zencrew.mapper.EmployeeMapper;
import com.hrms.zencrew.repository.DepartmentRepository;
import com.hrms.zencrew.repository.EmployeeRepository;
import com.hrms.zencrew.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
		
		private final EmployeeRepository employeeRepo;
		
		private final DepartmentRepository departmentRepo;
		
		private final EmployeeMapper employeeMap;
	
		
		
	public EmployeeServiceImpl(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo,
				EmployeeMapper employeeMap) {
			this.employeeRepo = employeeRepo;
			this.departmentRepo = departmentRepo;
			this.employeeMap = employeeMap;
		}

	@Override
	public EmployeeResponseDto createEmployee(EmployeeRequestDto dto) {

		if (employeeRepo.existsByEmail(dto.getEmail())) {
	        throw new IllegalArgumentException("Email already exists.");
	    }
		
		if(employeeRepo.existsByPhone(dto.getPhone())) {
			throw new IllegalArgumentException("Phone number already exists.");
		}
		
		  Department department = departmentRepo.findById(dto.getDepartmentId())
		            .orElseThrow(() ->
		                    new ResourceNotFoundException("Department not found."));
		  Employee emp = new Employee();
		  
		  emp.setName(dto.getName());
		  emp.setAge(dto.getAge());
		  emp.setEmail(dto.getEmail());
		  emp.setPhone(dto.getPhone());
		  emp.setAddress(dto.getAddress());
		  emp.setDepartment(department);
		  
		  Employee saved = employeeRepo.save(emp);
		  
		
		return employeeMap.toResponseDto(saved);
	
	}

	@Override
	public List<EmployeeResponseDto> getAllEmployee() {

		return employeeRepo.findAll().stream().map(employeeMap::toResponseDto).toList();
	}

	@Override
	public EmployeeResponseDto getAllEmployeeById(Long id) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found."));
		return employeeMap.toResponseDto(employee);
	}

	@Override
	public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto dto) {

		Employee emp = employeeRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found."));
		
		if (employeeRepo.existsByEmail(dto.getEmail())) {
	        throw new IllegalArgumentException("Email already exists.");
	    }
		
		if(employeeRepo.existsByPhone(dto.getPhone())) {
			throw new IllegalArgumentException("Phone number already exists.");
		}
		
		Department department = departmentRepo.findById(dto.getDepartmentId())
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Department not found."));
		
		  emp.setName(dto.getName());
		  emp.setAge(dto.getAge());
		  emp.setEmail(dto.getEmail());
		  emp.setPhone(dto.getPhone());
		  emp.setAddress(dto.getAddress());
		  emp.setDepartment(department);
		
		  Employee updated = employeeRepo.save(emp);
		
		   return employeeMap.toResponseDto(updated) ;
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee emp = employeeRepo.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		
		employeeRepo.delete(emp);
	
		
	}
	
	

}
