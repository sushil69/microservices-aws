package com.javaa.employee.reg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaa.employee.reg.DTO.UserRequestDto;
import com.javaa.employee.reg.DTO.UserResponseDto;
import com.javaa.employee.reg.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserRegistrationController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger =
            LoggerFactory.getLogger(UserRegistrationController.class);

	// Add new user 
	@PostMapping("/register")
	public ResponseEntity<UserResponseDto> addUser(
	        @Valid @RequestBody UserRequestDto userDto) {

	    UserResponseDto response = userService.registerUser(userDto);
	    return  ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	
	
	// get existing user from DB 
	
	@GetMapping("/getuserbyid/{id}") public ResponseEntity<UserResponseDto>
	  getUserById(@PathVariable Long id) {
	  
	  logger.info("Received request to fetch user with id: {}", id);
	  UserResponseDto userResponseDto = userService.getUserById(id);
	  logger.info("Successfully fetched user with id: {}", id); return
	  ResponseEntity.ok(userResponseDto); }
	  
	
	// get all existing user from DB 
	
	  @GetMapping("/allUsers") public ResponseEntity<List<UserResponseDto>>
	  getAllUsers() { List<UserResponseDto> userResponseDto =
	  userService.getAllUser(); return ResponseEntity.ok(userResponseDto); }
	  
	 //  update existing user by using id from DB 
		
	  @PutMapping("/updateuser/{id}") ResponseEntity<UserResponseDto>
	  updateUser(@Valid @RequestBody UserRequestDto userDto, @PathVariable Long id)
	  { UserResponseDto userResponseDto = userService.updateUser(userDto, id);
	  return ResponseEntity.ok(userResponseDto);
	  
	  }
	 
	 
}
