package com.flightapp.schedule.modal;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fares implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	
	@ManyToOne(fetch = FetchType.LAZY )
	private FlightSchedule flightSchedule;
	 	
	private Double fare;
	private String currency;
	private String fareClass;
	
	
	public Fares() {
		super();
	}

	
	public Fares(long id, Double fare, String currency, String fareClass) {
		super();
		this.id = id;
		this.fare = fare;
		this.currency = currency;
		this.fareClass = fareClass;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}

	public String getFareClass() {
		return fareClass;
	}

	public void setFareClass(String fareClass) {
		this.fareClass = fareClass;
	}


	@Override
	public String toString() {
		return "Fares [id=" + id + ", flightSchedule=" + flightSchedule + ", fare=" + fare + ", currency=" + currency
				+ ", fareClass=" + fareClass + "]";
	}


}