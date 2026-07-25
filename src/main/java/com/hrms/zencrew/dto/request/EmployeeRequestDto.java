package com.hrms.zencrew.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmployeeRequestDto {
	
	@NotBlank(message = "Employee name is required")
	private String name;
	
	
	@Min(value = 18)
	@Max(value = 60)
	private Integer age;
	
	@Email
	private String email;
	
	@Pattern(
			regexp = "[6-9]\\d{9}$",
			message = "Invalid phone number")
	private String phone;
	
	@NotBlank
	private String address;
	
	@NotBlank(message = "Department is required")
	private Long departmentId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	
}
