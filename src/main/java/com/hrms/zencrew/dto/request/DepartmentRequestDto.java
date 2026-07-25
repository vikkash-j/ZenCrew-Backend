package com.hrms.zencrew.dto.request;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDto {
	
	@NotBlank (message = "Department name is required")
	private String departmentName;
	
	@NotBlank (message = "Location is required")
	private String location;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
