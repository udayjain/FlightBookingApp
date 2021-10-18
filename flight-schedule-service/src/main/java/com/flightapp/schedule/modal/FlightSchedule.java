package com.flightapp.schedule.modal;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "CR_AT", "UP_AT" }, allowGetters = true)
public class FlightSchedule implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@NotNull
	@Column(name ="Flight_NO" , unique = true)
	private String flightNumber; 
	
	@NotNull
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Flight flight;
	
	@FutureOrPresent
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date flightDate;
	
	@JsonFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)	
	private Date departureTime;
	
	@JsonFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)	
	private Date arrivalTime;
	
	/*
	 * @OneToMany private Set<String> flightDays;
	 */
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Fares> fares;	
	
	private String mealType;
	
 	private String discount;
	
 	private EFlight flightStatus;	
	
	@Column(name = "CR_AT", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date crAt;

	
	@Column(name = "UP_AT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
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

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public EFlight getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(EFlight flightStatus) {
		this.flightStatus = flightStatus;
	}

	

	public Set<Fares> getFares() {
		return fares;
	}

	public void setFares(Set<Fares> fares) {
		this.fares = fares;
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

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	
}
