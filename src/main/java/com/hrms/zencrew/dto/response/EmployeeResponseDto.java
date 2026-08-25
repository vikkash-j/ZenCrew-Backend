package com.hrms.zencrew.dto.response;

import com.hrms.zencrew.entity.Role;

public class EmployeeResponseDto {

		private  Long id;
		
		private String name;
		
		private Integer age;
		
		private String email;
		
		private String phone;
		
		private String address;
		
		private String departmentName;
		
		private Role role;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

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

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "EmployeeResponseDto [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", phone="
					+ phone + ", address=" + address + ", departmentName=" + departmentName + ", role=" + role + "]";
		}

		public EmployeeResponseDto(Long id, String name, Integer age, String email, String phone, String address,
				String departmentName, Role role) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.email = email;
			this.phone = phone;
			this.address = address;
			this.departmentName = departmentName;
			this.role = role;
		}

		public EmployeeResponseDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
}
