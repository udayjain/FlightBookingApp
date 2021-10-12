package com.flightapp.admin.modal;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"CR_AT", "UP_At"}, 
allowGetters = true)
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	private String flightType;
	
	@JsonFormat(pattern = "HH:MM")
	private String duration;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Airport  srcAiport;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Airport destAiport;

	@OneToMany 
	private Set<Seat> seats;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Airline airline;
	
	@Column(name = "CR_AT" ,nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
    private Date CreatedAt;
	
	@Column(name = "UP_AT" ,nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifiedOn;
	
	@Column(columnDefinition="tinyint(1) default 1")
	private boolean active;
	
	
	public Flight() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	
	public Airport getSrcAiport() {
		return srcAiport;
	}


	public void setSrcAiport(Airport srcAiport) {
		this.srcAiport = srcAiport;
	}


	public Airport getDestAiport() {
		return destAiport;
	}


	public void setDestAiport(Airport destAiport) {
		this.destAiport = destAiport;
	}


	public Set<Seat> getSeats() {
		return seats;
	}


	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}


	public Airline getAirline() {
		return airline;
	}


	public void setAirline(Airline airline) {
		this.airline = airline;
	}


	public Date getCreatedAt() {
		return CreatedAt;
	}


	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}


	public Date getModifiedOn() {
		return modifiedOn;
	}


	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	public String getFlightType() {
		return flightType;
	}


	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}	
}
