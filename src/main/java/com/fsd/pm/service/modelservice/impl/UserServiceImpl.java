package com.fsd.pm.service.modelservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.pm.service.model.User;
import com.fsd.pm.service.modelservice.UserService;
import com.fsd.pm.service.persistence.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository; 
	
	public User  getUser(Long id) {
		return userRepository.getOne(id);
	}
	
	public User adduser(User user) {
		return userRepository.save(user);
	}
	

}
