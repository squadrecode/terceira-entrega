package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	
	//
	
	@Query("SELECT u from User u JOIN FETCH u.roles WHERE u.username = :username")
	User findByUsernameFetchRoles(@Param("username") String username);
}
