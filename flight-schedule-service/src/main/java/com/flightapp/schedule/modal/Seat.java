package com.flightapp.schedule.modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seat implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int totalSeat;
	private String bookingClass;
	
	@ManyToOne
	private FlightSchedule flightSchedule;
	
	public Seat() {
		super();
	}

	public Seat(int totalSeat, String bookingClass) {
		super();
		this.totalSeat = totalSeat;
		this.bookingClass = bookingClass;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public String getBookingClass() {
		return bookingClass;
	}
	

}
