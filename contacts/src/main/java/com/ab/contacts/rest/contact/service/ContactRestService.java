package com.ab.contacts.rest.contact.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ab.contacts.dbo.Address;
import com.ab.contacts.dbo.Contact;
import com.ab.contacts.repository.AddressRepository;
import com.ab.contacts.repository.ContactRepository;

@Service
public class ContactRestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactRestService.class);

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private AddressRepository addressRepository;

	public ResponseEntity<?> createContact(Contact contact) {

		contactRepository.save(contact);
		return new ResponseEntity<>("Contact successfully saved.", HttpStatus.OK);
	}

	public ResponseEntity<?> getAllContacts() {
		List<Contact> contacts = contactRepository.findAll();

		LOGGER.info("List of all existing contacts: {}", contacts);

		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}

	public ResponseEntity<?> getContactsByZipCode(String zipCode) {
		
		Address address = addressRepository.findByZipCode(zipCode);
		
		if(address == null) {
			LOGGER.info("There are no any address with {} zip code.", zipCode);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			List<Contact> contactsByZipCode = contactRepository.findByAddress(address);

			LOGGER.info("List of existing contacts by zip code {}: {}", zipCode, contactsByZipCode);
			
			return new ResponseEntity<>(contactsByZipCode, HttpStatus.OK);
		}
		
	}

}
