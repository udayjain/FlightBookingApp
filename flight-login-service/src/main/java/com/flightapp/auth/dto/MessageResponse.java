package com.flightapp.auth.dto;

public class MessageResponse {
	private String message;
	private int statusCode;
	
	
	public MessageResponse() {
		super();
	}
	public MessageResponse(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	public MessageResponse(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	
	
	
}
