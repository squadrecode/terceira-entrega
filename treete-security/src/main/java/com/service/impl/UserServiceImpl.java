package com.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.exception.ErroAutenticacao;
import com.exception.ResourceNotFoundException;
import com.repositories.UserRepository;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public BCryptPasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public User save(User user) {
		User existsUser = userRepository.findByUsername(user.getUsername());
		
		if(existsUser != null) {
			throw new ErroAutenticacao("Usuário existente!");
		}
		user.setPassword(passwordEncode().encode(user.getPassword()));
		
		User createdUser = userRepository.save(user);
		return createdUser;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Usuário", "id", id));
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User update(User user, long id) {
		User userExists = userRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Usuário", "id", id));
		
		userExists.setName(user.getName());
		userExists.setUsername(user.getUsername());
		userExists.setPassword(user.getPassword());
		userExists.setRoles(user.getRoles());

		userRepository.save(userExists);
		return userExists;
	}

	@Override
	public void delete(User user) {
		Objects.requireNonNull(user.getId());
		userRepository.delete(user);
	}

}
