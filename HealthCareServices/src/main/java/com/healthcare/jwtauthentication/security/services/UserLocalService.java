package com.healthcare.jwtauthentication.security.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.healthcare.jwtauthentication.model.User;

public interface UserLocalService extends UserDetailsService{
	Iterable<User> findAll();
	Optional<User> findById(long id);
	String save(User user);
	
}
