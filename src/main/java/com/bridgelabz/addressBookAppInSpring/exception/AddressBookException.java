package com.bridgelabz.addressBookAppInSpring.exception;

public class AddressBookException extends RuntimeException{
	
	// constructor for the error message as a parameter
	public AddressBookException(String msg) {
		super(msg);
	}
}
