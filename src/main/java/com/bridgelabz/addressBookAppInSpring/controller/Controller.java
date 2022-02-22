package com.bridgelabz.addressBookAppInSpring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressBookAppInSpring.dto.AddressBookDTO;
import com.bridgelabz.addressBookAppInSpring.dto.ResponceDTO;
import com.bridgelabz.addressBookAppInSpring.model.AddressBookModel;
import com.bridgelabz.addressBookAppInSpring.service.AddressBookService;

@RestController
public class Controller {

	@Autowired
	AddressBookService service;

	// hello msg printing 
	@GetMapping("/hello")
	public String sayHello() {
		return "welocome to Address book ";
	}

	// hello msg with name
	@PostMapping("/nameHi")
	public String mapbyName(@RequestParam String name) {
		return name + " ! welcome to Address book system";
	}

	// Saving the data in the local modal object. 
	@PostMapping("/save")
	public String setBook(@RequestBody AddressBookModel addressBookobj) {
		String msg = service.saveBook(addressBookobj);
		return msg;
	}

	// save the data in the repo by dto
	@PostMapping("/saveByDTO")
	public ResponseEntity<ResponceDTO> savedatabyDTO(@Valid @RequestBody AddressBookDTO addressBookdto) {
		AddressBookModel newAddressBook = service.saveAddressBookDataByDTO(addressBookdto);
		ResponceDTO dto = new ResponceDTO("sucussfully saved contect", newAddressBook);
		return new ResponseEntity(dto, HttpStatus.OK);
	}

	// find all by id
	@GetMapping("/findAll")
	public List<AddressBookModel> findAll() {
		List<AddressBookModel> addressBooklist = service.findAll();
		return addressBooklist;
	}

	// find by id
	@GetMapping("/findById/{id}")
	public AddressBookModel setBook(@PathVariable int id) {
		AddressBookModel addressBookobj = service.findBookById(id);
		return addressBookobj;
	}

	// update the data in the repo
	@PutMapping("/update/{id}")
	public AddressBookModel updateBookById(@PathVariable int id, @RequestBody AddressBookModel obj) {
		AddressBookModel addressBookobj = service.updatebyID(id, obj);
		return addressBookobj;
	}

	// update the data in the repo by dto
	@PostMapping("/updateByDTO/{id}")
	public ResponseEntity<ResponceDTO> updateDatabyDTOUsingId(@Valid @RequestBody AddressBookDTO addressBookdto,
			@PathVariable int id) {
		AddressBookModel newAddressBook = service.updateAddressBookDataByDTO(addressBookdto, id);
		ResponceDTO dto = new ResponceDTO("sucussfully updated contect", newAddressBook);
		return new ResponseEntity(dto, HttpStatus.OK);
	}

	// delete by id
	@DeleteMapping("/delete/{id}")
	public String deleteAddressBookBYId(@PathVariable int id) {
		String msg = service.deletebyID(id);
		return msg;
	}

}