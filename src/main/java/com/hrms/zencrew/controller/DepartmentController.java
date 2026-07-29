package com.hrms.zencrew.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.zencrew.dto.request.DepartmentRequestDto;
import com.hrms.zencrew.dto.response.DepartmentResponseDto;
import com.hrms.zencrew.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	
	
	public DepartmentController(DepartmentService departmentService) {

		this.departmentService = departmentService;
		}
	
	@PostMapping("/create")
	public ResponseEntity<DepartmentResponseDto> createDepartment(
			@Valid @RequestBody DepartmentRequestDto  dto) {
		return new ResponseEntity<>(departmentService.createDepartment(dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<DepartmentResponseDto>> getAllDeapartment(){
		return ResponseEntity.ok(departmentService.getAllDepartments());
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<DepartmentResponseDto> getAllDepartment(@PathVariable Long id){
		return ResponseEntity.ok(departmentService.getDepartmentById(id));
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<DepartmentResponseDto> updateDepartment(@PathVariable Long id,
			@Valid @RequestBody DepartmentRequestDto dto){
		return ResponseEntity.ok(departmentService.updateDepartment(id, dto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
		departmentService.deleteDepartment(id);
		return ResponseEntity.noContent().build();	
		
	}
	

}
