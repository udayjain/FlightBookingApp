package com.flightapp.auth.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.NoArgsConstructor;

public class SignUpRequest {
 
    @NotEmpty
    @Size(max =20)
    private String firstName;
    
    @NotEmpty
    @Size(max =20)
    private String lastName;
 
    @NotEmpty
    @Email
    private String emailId;
 
    private long mobNo;
    
    @Past
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dob;
    
    @Size(min = 6)
    private String password;
    
    @NotEmpty
    private String gender;

    
    
	public SignUpRequest() {
		super();
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "SignUpRequest [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", mobNo="
				+ mobNo + ", dob=" + dob + ", password=" + password + ", gender=" + gender + "]";
	}
    
    
}
