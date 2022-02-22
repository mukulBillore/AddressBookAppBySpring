package com.bridgelabz.addressBookAppInSpring.dto;

import com.bridgelabz.addressBookAppInSpring.model.AddressBookModel;

public class ResponceDTO {
	private String msg;
	private Object data;

	
	
	// constructor with string and model ref as parameter
	public ResponceDTO(String string, AddressBookModel newAddressBook) {
		this.msg = string;
		this.data = newAddressBook;
	}
	
	
	// default constructor
	public ResponceDTO() {
	}

	
	// getters and setters
	// why do we need getters and setters here

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


}
