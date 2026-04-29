package com.javaa.employee.reg.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javaa.employee.reg.custom.exception.CustomErrorResponse;
import com.javaa.employee.reg.custom.exception.UserAlreadyExistsException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	ResponseEntity<CustomErrorResponse> handleUserAlreadyExistException(UserAlreadyExistsException ex,
			HttpServletRequest request) {

		CustomErrorResponse response = new CustomErrorResponse(HttpStatus.CONFLICT.value(), "User Already Exists",
				ex.getMessage(), request.getRequestURI());

		return new ResponseEntity<>(response, HttpStatus.CONFLICT);

	}

}
