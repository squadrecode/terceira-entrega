package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserRoleDTO;
import com.entity.User;
import com.service.RoleService;
import com.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@PostMapping("/create")
	public User save(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PostMapping("/acess")
	public User role(@RequestBody UserRoleDTO userRoleDTO) {
		return roleService.execute(userRoleDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> user = userService.getAllUsers();
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long UserId){
		return new ResponseEntity<User>(userService.getUserById(UserId),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody User u) {
		return new ResponseEntity<User>(userService.update(u, id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		return userService.findById(id).map(entity ->{
			userService.delete(entity);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Usuário não encontrado",HttpStatus.BAD_REQUEST));
	}
	
}
