package com.healthcare.jwtauthentication.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.jwtauthentication.model.Doctor;
import com.healthcare.jwtauthentication.model.User;
import com.healthcare.jwtauthentication.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserLocalService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));

		return UserPrinciple.build(user);
	}
	
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
    
	@Override
	public String save(User entity) {
		User newUser=userRepository.save(entity);
			return "Saved"+newUser;
		}
	@Override
    public Optional<User> findById(long id) 
    {			
 	 return userRepository.findById(id);
	}
	
}