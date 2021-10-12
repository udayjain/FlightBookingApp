package com.flightapp.admin.modal;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FlightSchedule {
	
	private long id;
	@NotBlank
	private String flightNumber; 
	
	@NotNull
	private Flight flight;	
	
	@NotBlank
	private String flightDate;
	
	@NotBlank
	private String departureTime;
	
	@NotBlank
	private String arrivalTime;
	
	@NotBlank
	private String flightStatus;		
	
	private Map<String,Fares> fares;
	
	
	private String discount;
	
	@NotBlank
	private String mealType;
	
	private Date crAt;

	private Date upAt;
	

	public FlightSchedule() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	public Map<String, Fares> getFares() {
		return fares;
	}

	public void setFares(Map<String, Fares> fares) {
		this.fares = fares;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public Date getCrAt() {
		return crAt;
	}

	public void setCrAt(Date crAt) {
		this.crAt = crAt;
	}

	public Date getUpAt() {
		return upAt;
	}

	public void setUpAt(Date upAt) {
		this.upAt = upAt;
	}

}
