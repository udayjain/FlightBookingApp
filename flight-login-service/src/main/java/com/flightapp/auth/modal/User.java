package com.flightapp.auth.modal;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(	name = "USERS", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "MOB_NO"),
			@UniqueConstraint(columnNames = "EMAIL_ID") 
		})

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"CR_AT", "UP_At"}, 
allowGetters = true)
public class User implements Serializable {
	private static final long serialVersionUID = 65981149772133526L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID" )
    private Long id;
	
    @NotBlank
	@Size(max = 50)
    @Email
    @Column(name ="EMAIL_ID")
    private String emailId;    
    
    @Past
    private Date dob;
 
    @Column(name = "Active", columnDefinition = "BIT", length = 1)
    private boolean active;
   
    @NotBlank
	@Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
   
    @NotBlank
	@Size(max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @NotBlank
   	@Size(max = 20)
    @Column(name = "sex")
    private String gender;
    
    @Column(name = "MOB_NO")
    private long mobNO;
       
    @JsonIgnore
    @Column(name = "CR_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createdDate;
    
    @JsonIgnore
    @Column(name = "UP_AT",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date modifiedDate;
 
    @NotBlank
	@Size(max = 120)
    private String password;

 
    // bi-directional many-to-many association to Role
   
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    public User() {
		super();
	}
    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
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


	public long getMobNO() {
		return mobNO;
	}


	public void setMobNO(long mobNO) {
		this.mobNO = mobNO;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}    
}
