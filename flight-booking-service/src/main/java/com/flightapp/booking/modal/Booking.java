package com.flightapp.booking.modal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Booking implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String pnr;
	
	private Long userId;
	
	private String  emailID;
	
	private Long flightSchdeuleId;
	
	private Date bookingDate;
	
	private String status;
	
	private int noOfPassenger;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Passenger> passengers;

	private double fare;
	private double totalFare;
	
	private String bookClass;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public Long getFlightSchdeuleId() {
		return flightSchdeuleId;
	}

	public void setFlightSchdeuleId(Long flightSchdeuleId) {
		this.flightSchdeuleId = flightSchdeuleId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getBookClass() {
		return bookClass;
	}

	public void setBookClass(String bookClass) {
		this.bookClass = bookClass;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookClass, bookingDate, fare, flightSchdeuleId, id, noOfPassenger, passengers, pnr, status,
				totalFare);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookClass, other.bookClass) && Objects.equals(bookingDate, other.bookingDate)
				&& Double.doubleToLongBits(fare) == Double.doubleToLongBits(other.fare)
				&& Objects.equals(flightSchdeuleId, other.flightSchdeuleId) && Objects.equals(id, other.id)
				&& noOfPassenger == other.noOfPassenger && Objects.equals(passengers, other.passengers)
				&& Objects.equals(pnr, other.pnr) && Objects.equals(status, other.status)
				&& Double.doubleToLongBits(totalFare) == Double.doubleToLongBits(other.totalFare);
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", pnr=" + pnr + ", flightSchdeuleId=" + flightSchdeuleId + ", bookingDate="
				+ bookingDate + ", status=" + status + ", noOfPassenger=" + noOfPassenger + ", passengers=" + passengers
				+ ", fare=" + fare + ", totalFare=" + totalFare + ", bookClass=" + bookClass + "]";
	}
	
	
}
