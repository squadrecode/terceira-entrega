package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Contact;
import com.repositories.ContactRepository;
import com.service.ContactService;
import com.service.impl.ContactServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("api/contact")
public class ContactController {

	@Autowired
	private ContactRepository repository;
	
	@Autowired
	private ContactServiceImpl service;
	
	@Autowired
	private ContactService contatoService;
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody Contact contato) {
		return new ResponseEntity<Contact>(service.save(contato), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Contact>> findAll(){
		List<Contact> contatos = service.getAllContacts();
		return ResponseEntity.ok().body(contatos);
	}
		
	@GetMapping("{id}")
	public ResponseEntity<Contact> getContatoById(@PathVariable("id") long ContatoId){
		return new ResponseEntity<Contact>(service.getContactById(ContatoId), HttpStatus.OK);
	}
}