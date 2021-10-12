package com.flightapp.auth.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class JwtResponse {
	
	private Long id;
	private String userName;
	private String emailId;
	private String jwt ;
	private List<String> roles;
	
	public JwtResponse() {
		super();
		
	}
	
	public JwtResponse(String jwt, Long id, String userName, String emailId, List<String> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.jwt = jwt;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
}
