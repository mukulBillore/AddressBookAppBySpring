package com.bridgelabz.addressBookAppInSpring.dto;

import com.bridgelabz.addressBookAppInSpring.model.AddressBookModel;

public class ResponceDTO {
	private String msg;
	private Object data;

	
	
	// constructor with string and model ref as parameter
	public ResponceDTO(String msg, Object data) {
		super();
		this.msg = msg;
		this.data = data;
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
