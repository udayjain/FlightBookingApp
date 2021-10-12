package com.flightapp.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginRequest {
	
	@Email
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
	
	public LoginRequest() {
		super();
		
	}
	public LoginRequest(@Email @NotBlank String userName, @NotBlank String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
