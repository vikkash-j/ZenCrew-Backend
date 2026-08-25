package com.hrms.zencrew.dto.response;

import com.hrms.zencrew.entity.Role;

public class LoginResponseDto {
	
	private String token;
	
	private String email;
	
	private Role role;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LoginResponseDto(String token, String email, Role role) {
		super();
		this.token = token;
		this.email = email;
		this.role = role;
	}

	public LoginResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
