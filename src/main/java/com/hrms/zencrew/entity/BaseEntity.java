package com.hrms.zencrew.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


@MappedSuperclass
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "created_At", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_At")
	private LocalDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public BaseEntity(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public BaseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PrePersist
	public void onCreate() {
		createdAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {
		updatedAt = LocalDateTime.now();
	}
}
