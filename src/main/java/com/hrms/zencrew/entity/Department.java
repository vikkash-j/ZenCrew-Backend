package com.hrms.zencrew.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Departments")
public class Department extends BaseEntity{
	
	@NotBlank(message = "Department name is required")
	@Column(name = "department_name", nullable = false, unique = true)
	private String departmentName;
	
	@NotBlank(message = "Location is required")
	@Column(nullable = false)
	private String location;
	
	@OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Employee> employees = new ArrayList<>();

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", location=" + location + "]";
	}

	public Department(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String departmentName, String location,
			List<Employee> employees) {
		super(id, createdAt, updatedAt);
		this.departmentName = departmentName;
		this.location = location;
		this.employees = employees;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(id, createdAt, updatedAt);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	

}
