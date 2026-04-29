package com.javaa.employee.reg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaa.employee.reg.DTO.UserRequestDto;
import com.javaa.employee.reg.DTO.UserResponseDto;

@Service
public interface UserService {
	public UserResponseDto registerUser(UserRequestDto userdto);

	public UserResponseDto getUserById(Long id);

	public List<UserResponseDto> getAllUser();

	public UserResponseDto updateUser(UserRequestDto userdto, Long id);

}
