package com.javaa.employee.reg.DTO;

import java.util.HashSet;
import java.util.Set;

import com.javaa.employee.reg.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDto {

	@NotBlank(message = "Full name is required")
	private String fullName;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 8, message = "Password must be at least 8 characters")
	private String password;

	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid mobile number")
	private String mobile;
	
	@NotNull(message = "Roles cannot be null")
	private Set<Role> roles = new HashSet<>();

	public UserRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public UserRequestDto(@NotBlank(message = "Full name is required") String fullName,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
			@NotBlank(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters") String password,
			@NotBlank(message = "Mobile number is required") @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid mobile number") String mobile,@NotNull Set<Role> roles) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.roles = roles;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	}
