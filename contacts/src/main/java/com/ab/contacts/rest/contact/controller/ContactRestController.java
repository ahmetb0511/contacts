package com.ab.contacts.rest.contact.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ab.contacts.dbo.Contact;
import com.ab.contacts.rest.contact.service.ContactRestService;

@RestController
@RequestMapping("/api/contact")
public class ContactRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactRestController.class);

	@Autowired
	private ContactRestService contactRestService;

	public void setContactRestService(ContactRestService contactRestService) {
		this.contactRestService = contactRestService;
	}
	
	@RequestMapping(value = { "/create" }, method = { RequestMethod.POST })
	public ResponseEntity<?> createContact(@RequestBody Contact contact) {
		LOGGER.info("Incoming request to create contact: {}", contact);
		return contactRestService.createContact(contact);
	}

	@RequestMapping(value = { "/get-all-contacts" }, method = { RequestMethod.GET })
	public ResponseEntity<?> getAllContacts() {
		LOGGER.info("Incoming request to get list of all existing contacts.");
		return contactRestService.getAllContacts();
	}
	
	@RequestMapping(value = { "/get-by-zip-code/{zipCode}" }, method = { RequestMethod.GET })
	public ResponseEntity<?> getContactsByZipCode(@PathVariable(name="zipCode") String zipCode) {
		LOGGER.info("Incoming request to get list of all existing contacts by zip code: {}", zipCode);
		return contactRestService.getContactsByZipCode(zipCode);
	}
}
