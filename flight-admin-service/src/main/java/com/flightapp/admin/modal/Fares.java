package com.flightapp.admin.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class Fares {

	private long id;
	
	private FlightSchedule flightSchedule;
	
	private String fare;
	private String currency;

	public Fares(String fare, String currency) {

		this.fare = fare;
		this.currency = currency;
	}

	public Fares() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Fares [id=" + id + ", fare=" + fare + ", currency=" + currency + "]";
	}

}