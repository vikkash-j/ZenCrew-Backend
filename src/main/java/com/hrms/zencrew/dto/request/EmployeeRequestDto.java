package com.hrms.zencrew.dto.request;

import com.hrms.zencrew.entity.Role;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull(message = "Department is required")
	private Long departmentId;
	
	@NotNull(message = "Password is required")
	private String password;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@NotNull(message = "Role is required")
	private Role role;

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
	
	@Override
	public String toString() {
		return "EmployeeRequestDto [name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", departmentId=" + departmentId + ", password=" + password + ", role="
				+ role + "]";
	}

	public EmployeeRequestDto(@NotBlank(message = "Employee name is required") String name,
			@Min(18) @Max(60) Integer age, @Email String email,
			@Pattern(regexp = "[6-9]\\d{9}$", message = "Invalid phone number") String phone, @NotBlank String address,
			@NotNull(message = "Department is required") Long departmentId,
			@NotNull(message = "Password is required") String password,
			@NotNull(message = "Role is required") Role role) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.departmentId = departmentId;
		this.password = password;
		this.role = role;
	}

	public EmployeeRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
