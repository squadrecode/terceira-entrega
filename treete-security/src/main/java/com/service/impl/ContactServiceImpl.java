package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Contact;
import com.exception.ResourceNotFoundException;
import com.repositories.ContactRepository;
import com.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(long id) {
		return contactRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Usuário", "id", id));
	}

	
}
