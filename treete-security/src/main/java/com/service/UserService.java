package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.entity.User;

public interface UserService {

	BCryptPasswordEncoder passwordEncode();
	
	User save(User user);
	
	List<User> getAllUsers();
	
	User getUserById(long id);
	
	Optional<User> findById(Long id);
	
	User update(User user, long id);
	
	void delete(User user);
}
