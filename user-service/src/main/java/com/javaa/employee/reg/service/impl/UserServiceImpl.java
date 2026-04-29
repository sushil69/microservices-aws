package com.javaa.employee.reg.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaa.employee.reg.DTO.UserRequestDto;
import com.javaa.employee.reg.DTO.UserResponseDto;
import com.javaa.employee.reg.custom.exception.UserAlreadyExistsException;
import com.javaa.employee.reg.entity.Role;
import com.javaa.employee.reg.entity.User;
import com.javaa.employee.reg.repository.RoleRepository;
import com.javaa.employee.reg.repository.UserRepository;
import com.javaa.employee.reg.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public UserResponseDto registerUser(UserRequestDto userReqdto) {

		userRepository.findByEmail(userReqdto.getEmail()).ifPresent(user -> {
			throw new UserAlreadyExistsException("User already exists with email: " + userReqdto.getEmail());});

		Set<Role> persistedRoles = new HashSet<>();
		for (Role role : userReqdto.getRoles()) {
			Role existingRole = roleRepository.findByName(role.getName()).orElse(null);
			if (existingRole == null) {
				existingRole = roleRepository.save(role);}

			  persistedRoles.add(existingRole);
		}

		User user = mapToEntity(userReqdto);
		user.setRoles(persistedRoles);
		User saveuser = userRepository.save(user);
		return mapToResponse(saveuser);
	}

	
	
	 @Override public UserResponseDto getUserById(Long id) { User user =
			  userRepository.getById(id); return mapToResponse(user); }
			  
	
	
		
		  @Override public List<UserResponseDto> getAllUser() { List<UserResponseDto>
		  UserResponseDtodata =
		  userRepository.findAll().stream().map(this::mapToResponse)
		  .collect(Collectors.toList()); return UserResponseDtodata; }
		  
		  
		  @Override public UserResponseDto updateUser(UserRequestDto userdto, Long id)
		  {
		  
		  User user = userRepository.findById(id).orElseThrow(() -> new
		  RuntimeException("User not found"));
		  
		  Role role = roleRepository.findById(id).orElseThrow(() -> new
		  RuntimeException("User not found"));
		  
		  
		  
		  if (user.getId().equals(id)) { user = mapToEntity(userdto); user.setId(id);
		  userRepository.save(user); }
		  
		  return mapToResponse(user); }
		 

	
	
	private User mapToEntity(UserRequestDto dto) {
	    User user = new User();
	    user.setFullName(dto.getFullName());
	    user.setEmail(dto.getEmail());
	    user.setPassword(dto.getPassword());
	    user.setMobile(dto.getMobile());
	    user.setRoles(dto.getRoles());
	    return user;
	}

	private UserResponseDto mapToResponse(User user) {
	    UserResponseDto dto = new UserResponseDto();
	    dto.setId(user.getId());
	    dto.setFullName(user.getFullName());
	    dto.setEmail(user.getEmail());
	    dto.setMobile(user.getMobile());
	    return dto;
	}

}
