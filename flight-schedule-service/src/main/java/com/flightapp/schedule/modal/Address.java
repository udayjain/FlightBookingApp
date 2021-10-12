package com.flightapp.schedule.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "CR_AT", "UP_AT" }, allowGetters = true)
public class Address implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	@Size(max = 50)
	private String country;
	
	@NotBlank
	@NotNull
	@Size(max = 50)
	private String state;
	
	@NotBlank
	@NotNull
	@Size(max = 50)
	private String city;
	
	@Size(max = 255)
	private String addLine1;
	
	@Size(max = 255)
	private String addLine2;
	
	@Size(max = 255)
	private String addLine3;
	
	@Min(6)
	private int pinCode;
	
	@Column(name = "CR_AT", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date crAt;


	@Column(name = "UP_AT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date upAt;


	public Address() {
		super();
	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddLine1() {
		return addLine1;
	}


	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}


	public String getAddLine2() {
		return addLine2;
	}


	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}


	public String getAddLine3() {
		return addLine3;
	}


	public void setAddLine3(String addLine3) {
		this.addLine3 = addLine3;
	}


	public int getPinCode() {
		return pinCode;
	}


	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
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
