package com.flightapp.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class UserAlreadyExistAuthenticationException extends RuntimeException {
	  private static final long serialVersionUID = 752858878580882829L;
	  
	public UserAlreadyExistAuthenticationException(String message) {
		super(message);
	}
	
}
