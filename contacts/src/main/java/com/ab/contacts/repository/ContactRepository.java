package com.ab.contacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.contacts.dbo.Address;
import com.ab.contacts.dbo.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	public List<Contact> findByAddress(Address address);
}
