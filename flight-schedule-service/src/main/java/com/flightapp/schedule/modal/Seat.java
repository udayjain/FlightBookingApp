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
	
	
	public Seat() {
		super();
	}	

	public Seat(long id, int totalSeat, String bookingClass) {
		super();
		this.id = id;
		this.totalSeat = totalSeat;
		this.bookingClass = bookingClass;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public void setBookingClass(String bookingClass) {
		this.bookingClass = bookingClass;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public String getBookingClass() {
		return bookingClass;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", totalSeat=" + totalSeat + ", bookingClass=" + bookingClass + "]";
	}
	

}
