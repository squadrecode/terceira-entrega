package com.service;

import java.util.List;

import com.entity.Contact;

public interface ContactService {

	Contact save(Contact contact);
	
	List<Contact> getAllContacts();
	
	Contact getContactById(long id);
}

