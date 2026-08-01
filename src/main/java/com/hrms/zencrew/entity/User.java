package com.hrms.zencrew.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User extends BaseEntity {
	
	@Column(nullable = false)
	private String userName ;
	
	@Column(nullable = false, unique = true)
	private String email;
		
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@Column(nullable = false)
	private Boolean enabled = true;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", enabled=" + enabled + "]";
	}

	public User(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String userName, String email,
			String password, Role role, Boolean enabled) {
		super(id, createdAt, updatedAt);
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(id, createdAt, updatedAt);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
