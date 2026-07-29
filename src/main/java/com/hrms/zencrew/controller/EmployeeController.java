package com.hrms.zencrew.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.zencrew.dto.request.EmployeeRequestDto;
import com.hrms.zencrew.dto.response.EmployeeResponseDto;
import com.hrms.zencrew.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	}

	@PostMapping("/create")
    public ResponseEntity<EmployeeResponseDto> createEmployee(
            @Valid @RequestBody EmployeeRequestDto dto) {

        return new ResponseEntity<>(
                employeeService.createEmployee(dto),
                HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployee() {

        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(employeeService.getAllEmployeeById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDto dto) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }
}