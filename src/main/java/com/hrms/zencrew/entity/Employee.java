package com.hrms.zencrew.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Employees")
public class Employee extends BaseEntity{
	
	@NotBlank(message = "Employee name is required")
	@Column(nullable = false)
	private String name;
	
	@Min(value = 18, message = "Age must be at least 18")
	@Max(value = 60, message = "Age must be less than or equal to 65")
	@Column(nullable = false)
	private Integer age;
	
	@Email(message = "Invalid email format")
	@Column(nullable = false, unique = true)
	private String email;
	
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
	@Column(nullable = false, unique = true)
	private String phone;
	
	@NotBlank(message = "Address is required")
	@Column(nullable = false)
	private String address;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false )
	private Department department;

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", department=" + department + "]";
	}

	public Employee(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, Integer age, String email,
			String phone, String address, Department department) {
		super(id, createdAt, updatedAt);
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.department = department;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(id, createdAt, updatedAt);
		// TODO Auto-generated constructor stub
	}
	
	
}
