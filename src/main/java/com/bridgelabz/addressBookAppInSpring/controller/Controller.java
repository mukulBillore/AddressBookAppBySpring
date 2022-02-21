package com.bridgelabz.addressBookAppInSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressBookAppInSpring.model.AddressBookModel;
import com.bridgelabz.addressBookAppInSpring.service.AddressBookService;

@RestController
public class Controller {

	@Autowired
	AddressBookService service;

	@GetMapping("/hello")
	public String sayHello() {
		return "welocome to Address book App";
	}

	@PostMapping("/nameHi")
	public String mapbyName(@RequestParam String name) {
		return name + " ! welcome to Address book system";
	}

	@PostMapping("/save/{id}")
	public String setBook(@PathVariable int id, @RequestBody AddressBookModel addressBookobj) {
		String msg = service.saveBook(addressBookobj, id);
		return msg;
	}
}