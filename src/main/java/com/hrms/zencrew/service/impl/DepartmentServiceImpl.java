package com.hrms.zencrew.service.impl;

import com.hrms.zencrew.mapper.EmployeeMapper;
import com.hrms.zencrew.repository.EmployeeRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.hrms.zencrew.dto.request.DepartmentRequestDto;
import com.hrms.zencrew.dto.response.DepartmentResponseDto;
import com.hrms.zencrew.entity.Department;
import com.hrms.zencrew.exception.ResourceNotFoundException;
import com.hrms.zencrew.mapper.DepartmentMapper;
import com.hrms.zencrew.repository.DepartmentRepository;
import com.hrms.zencrew.service.DepartmentService;

@Service
public class DepartmentServiceImpl  implements DepartmentService{
	
	
	private final DepartmentRepository departmentRepo;
	
	private final DepartmentMapper departmentMapper;


	DepartmentServiceImpl(DepartmentMapper departmentMapper, DepartmentRepository departmentRepo) {
		this.departmentMapper = departmentMapper;
		this.departmentRepo = departmentRepo;
	}


	@Override
	public DepartmentResponseDto createDepartment(DepartmentRequestDto dto) {
		
		if(departmentRepo.existsByDepartmentName(dto.getDepartmentName())) {
			throw new IllegalArgumentException("Department already exists.");
		}
		
		Department department = departmentMapper.toEntity(dto);
		
		Department savedepartment = departmentRepo.save(department);
		
		
		return departmentMapper.toResponseDto(savedepartment); 
	}

	@Override
	public List<DepartmentResponseDto> getAllDepartments() {
		
		return departmentRepo.findAll().stream().map(departmentMapper::toResponseDto).toList();
	}

	@Override
	public DepartmentResponseDto getDepartmentById(Long id) {
		
		Department department = departmentRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Department not found."));
		
		
		return departmentMapper.toResponseDto(department);
	}

	@Override
	public DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto dto) {
		
		Department department = departmentRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Department not found."));
		department.setDepartmentName(dto.getDepartmentName());
		department.setLocation(dto.getLocation());
		
		Department updated = departmentRepo.save(department);
		
		return departmentMapper.toResponseDto(updated);
	}

	@Override
	public void deleteDepartment(Long id) {
		Department department = departmentRepo.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Department not found."));

	    departmentRepo.delete(department);
	
		
	}
	
	
	

}
