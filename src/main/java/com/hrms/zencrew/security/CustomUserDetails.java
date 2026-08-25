package com.hrms.zencrew.security;

import java.util.Collection;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hrms.zencrew.entity.Employee;

public class CustomUserDetails implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;
	
	private final Employee employee;
	
	public CustomUserDetails(Employee employee) {
	this.employee = employee;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of( new SimpleGrantedAuthority("Role_"+ employee.getRole().name()));
	}

	@Override
	public String getPassword() {

		return employee.getPassword();
	}

	@Override
	public String getUsername() {
	
		return employee.getEmail() ;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
			
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
		
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
		
	}
	
	@Override
	public boolean isEnabled() {
		return true;
		
	}
	
	

}
