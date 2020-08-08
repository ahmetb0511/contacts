package com.ab.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.contacts.dbo.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	public Address findByZipCode(String zipCode);
}
