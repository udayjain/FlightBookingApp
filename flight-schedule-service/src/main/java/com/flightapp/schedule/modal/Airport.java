package com.flightapp.schedule.modal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "CR_AT", "UP_AT" }, allowGetters = true)
public class Airport implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@NotNull	
	private String name;
	
	@NotBlank
	@NotNull
	@Column(name = "AP_code", unique = true)
	private String code;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_ID" , nullable=false) 
	private Address address; 

	
	@Column(name = "CR_AT", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date crAt;


	@Column(name = "UP_AT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date upAt;

	@Column(columnDefinition="tinyint(1) default 1")
	private boolean active;
	
	/*
	 * @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ) private
	 * List<Flight> flights;
	 */
	public Airport() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/*
	 * public List<Flight> getFlights() { return flights; }
	 * 
	 * public void setFlights(List<Flight> flights) { this.flights = flights; }
	 */

}
