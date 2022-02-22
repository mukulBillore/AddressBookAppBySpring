package com.bridgelabz.addressBookAppInSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressBookAppInSpring.dto.AddressBookDTO;
import com.bridgelabz.addressBookAppInSpring.model.AddressBookModel;
import com.bridgelabz.addressBookAppInSpring.repository.AddressBookRepoInterface;

@Service
public class AddressBookService {
	@Autowired
	AddressBookRepoInterface repo;

	// save the details
	public String saveBook(AddressBookModel objAddressBook) {
		AddressBookModel addressBookObj = new AddressBookModel(objAddressBook);
		repo.save(addressBookObj);
		return "saved the person details  With name :" + addressBookObj.getFirstName() + " "
				+ addressBookObj.getLastName();
	}

	// save the details through dto
	public AddressBookModel saveAddressBookDataByDTO(AddressBookDTO addressBookdto) {
		AddressBookModel obj = new AddressBookModel(addressBookdto);
		repo.save(obj);
		return obj;
	}

	// update by id
	public AddressBookModel updatebyID(int id, AddressBookModel obj) {
		AddressBookModel addressBookObj = new AddressBookModel(obj, id);
		repo.save(addressBookObj);
		return repo.findById(id).get();
	}

	// delete service by id
	public String deletebyID(int id) {
		repo.deleteById(id);
		return "person is sucussfully deleted from  address book ";
	}

	// find by id
	public AddressBookModel findBookById(int id) {
		return repo.findById(id).get();

	}

	// find all
	public List<AddressBookModel> findAll() {
		List<AddressBookModel> listAddressBook = repo.findAll();
		return listAddressBook;
	}

}
