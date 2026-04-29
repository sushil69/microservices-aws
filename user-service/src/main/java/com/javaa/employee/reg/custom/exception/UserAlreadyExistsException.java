package com.javaa.employee.reg.custom.exception;

public class UserAlreadyExistsException extends RuntimeException {

	public UserAlreadyExistsException(String message) {

		super(message);

	}
}
