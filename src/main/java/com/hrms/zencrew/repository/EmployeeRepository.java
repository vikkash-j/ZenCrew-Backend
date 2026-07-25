package com.hrms.zencrew.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.zencrew.entity.Department;
import com.hrms.zencrew.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Optional<Employee> findByEmail(String email);
	
	Optional<Employee> findByPhone(String phone);
	
	boolean existsByEmail(String email);
	
	boolean existsByPhone(String phone);
	
	List<Employee> findByDepartment(Department department);
	
	
	

}
