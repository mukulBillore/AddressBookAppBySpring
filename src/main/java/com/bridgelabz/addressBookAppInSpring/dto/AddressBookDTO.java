package com.bridgelabz.addressBookAppInSpring.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;


public class AddressBookDTO {
	@NotEmpty(message="First name cant be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Person firstName is Invalid")
	private String firstName;

	@NotEmpty(message="Last name cant be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Person lastName is Invalid")
	private String lastName;
	@NotEmpty(message="Last name cant be empty")
	//@Pattern(regexp="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message="Employee lastName is Invalid")
	private String email;
	
	//@Length(max=10,message="error : your number is not of 10 digit")
	//@Length(min=10,message="error : your number is not of 10 digit")	
	private long phoneNumber;
	private String city;
	private String state;
	private Integer zip;

	// default constructor
	public AddressBookDTO() {	
	}

	// constructor using fields
	public AddressBookDTO(String firstName, String lastName, String email, long phoneNumber, String city, String state,
			Integer zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	// Getters and Setters for dto fields
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

}
