package com.ab.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ab.contacts")
public class ContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

}
