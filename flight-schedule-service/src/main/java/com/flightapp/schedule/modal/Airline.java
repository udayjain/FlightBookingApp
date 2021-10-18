package com.flightapp.schedule.modal;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "CR_AT", "UP_AT" }, allowGetters = true)
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY , generator = "airline")
	private Long id;
	
	@NotBlank
	@NotNull
	private String  airlineName;
	
	@NotBlank
	@NotNull
	private String airCode;
	
	private long contactNo;
	
	private String logo;
	
	@Column(columnDefinition="tinyint(1) default 1")
	private boolean active;
	
	
	@Column(name = "CR_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)	
	@CreatedDate
    private Date createdDate;
	
	@Column(name = "UP_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifiedDate;
	
	/*
	 * @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name="Airline_ID") private List<Flight> flights;
	 */
	
	public Airline() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAirlineName() {
		return airlineName;
	}


	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}


	public String getAirCode() {
		return airCode;
	}


	public void setAirCode(String airCode) {
		this.airCode = airCode;
	}


	public long getContactNo() {
		return contactNo;
	}


	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	/*
	 * public List<Flight> getFlights() { return flights; }
	 * 
	 * 
	 * public void setFlights(List<Flight> flights) { this.flights = flights; }
	 */
	
}
