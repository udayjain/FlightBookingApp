package com.flightapp.user.modal;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"cr_At", "up_At"}, allowGetters = true)

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	private String emailId;
	
	@NotBlank
	private LocalDate dob;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private int roleId;
	
	@NotBlank
	private long mobNO;
	
	private String city;
	
	@NotBlank
	private String country;
	private String state;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	
    private LocalDateTime crAt;
	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
	private LocalDateTime upAt;
	
	private String crByY;
	private String upBy;
	
	
	public User() {
		super();
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public long getMobNO() {
		return mobNO;
	}
	public void setMobNO(long mobNO) {
		this.mobNO = mobNO;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public LocalDateTime getCrAt() {
		return crAt;
	}
	public void setCrAt(LocalDateTime crAt) {
		this.crAt = crAt;
	}
	public LocalDateTime getUpAt() {
		return upAt;
	}
	public void setUpAt(LocalDateTime upAt) {
		this.upAt = upAt;
	}
	public String getCrByY() {
		return crByY;
	}
	public void setCrByY(String crByY) {
		this.crByY = crByY;
	}
	public String getUpBy() {
		return upBy;
	}
	public void setUpBy(String upBy) {
		this.upBy = upBy;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
}
