package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.entity"})
@EnableJpaRepositories(basePackages = {"com.repositories"})
@ComponentScan(basePackages = {"com.controller", "com.service", "com.service.impl", "com.security", "com.exception"})
@SpringBootApplication
public class TreeteSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreeteSecurityApplication.class, args);
	}

}
