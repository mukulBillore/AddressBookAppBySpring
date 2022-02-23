package com.bridgelabz.addressBookAppInSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressBookAppInSpring.dto.AddressBookDTO;
import com.bridgelabz.addressBookAppInSpring.exception.AddressBookException;
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

	// find by id
	public AddressBookModel findBookById(int id) {
		Optional<AddressBookModel> objAddressBook = repo.findById(id);
		if (objAddressBook.isEmpty()) {
			throw new AddressBookException("Person details not persent !! sorry please enter a valid ID");
		}
		return objAddressBook.get();

	}

	// find all data of addressbook
	public List<AddressBookModel> findAll() {
		List<AddressBookModel> listAddressBook = repo.findAll();
		return listAddressBook;
	}

	// update by id
	public AddressBookModel updatebyID(int id, AddressBookModel obj) {
		AddressBookModel addressBookObj;
		Optional<AddressBookModel> objAddressBook = repo.findById(id);
		if (objAddressBook.isEmpty()) {
			throw new AddressBookException("Person details not persent to update");
		} else {
			addressBookObj = new AddressBookModel(obj, id);
			repo.save(addressBookObj);
		}

		return repo.findById(id).get();
	}

	// update by dto
	public AddressBookModel updateAddressBookDataByDTO(AddressBookDTO addressBookdto, int id) {
		AddressBookModel obj = new AddressBookModel(addressBookdto, id);
		repo.save(obj);
		return repo.findById(id).get();

	}

	// delete service by id
	public String deletebyID(int id) {
		Optional<AddressBookModel> addressBookObj = repo.findById(id);
		if (addressBookObj.isEmpty()) {
			throw new AddressBookException("Person details not persent to delete");
		}

		repo.deleteById(id);
		return "person is sucussfully deleted from  address book ";
	}

}
