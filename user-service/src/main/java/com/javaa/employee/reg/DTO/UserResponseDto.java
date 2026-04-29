package com.javaa.employee.reg.DTO;

public class UserResponseDto {

	private Long id;
	private String fullName;
	private String email;
	private String mobile;

	public UserResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public UserResponseDto(Long id, String fullName, String email, String mobile) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
