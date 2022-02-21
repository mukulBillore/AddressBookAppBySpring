package com.bridgelabz.addressBookAppInSpring.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressBookAppInSpring.model.AddressBookModel;

@Service
public class AddressBookService {

	public String saveBook(AddressBookModel objAddressBook,Integer id) {
	   AddressBookModel addressBookObj = new AddressBookModel(objAddressBook,id);
		return "AdressBookObj With name :"+addressBookObj.getFirstName()+" "+addressBookObj.getLastName() ;
	}
	

}
