package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.UserRoleDTO;
import com.entity.Role;
import com.entity.User;
import com.exception.ErroAutenticacao;
import com.repositories.UserRepository;
import com.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User execute(UserRoleDTO userRoleDTO) {
		
		Optional<User> userExists = userRepository.findById(userRoleDTO.getIdUser());
		
		List<Role> roles = new ArrayList<>();
		
		if(userExists.isEmpty()) {
			throw new ErroAutenticacao("Usuário não encontrado");
		}
		
		roles = userRoleDTO.getIdsRoles().stream().map(role ->{
			return new Role(role);
		}).collect(Collectors.toList());
		
		User user = userExists.get();
		
		user.setRoles(roles);
		
		userRepository.save(user);
		
		return user;
	}

	
}
