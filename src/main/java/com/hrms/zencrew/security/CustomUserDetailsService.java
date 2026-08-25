package com.hrms.zencrew.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrms.zencrew.entity.Employee;
import com.hrms.zencrew.repository.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Employee employee = employeeRepository.findByEmail(email).orElseThrow(() 
				             -> new UsernameNotFoundException("Employee not found with email: " + email));
		
		return new CustomUserDetails(employee) ;
	}
	
	

}
