package com.fsd.pm.service.modelservice;

import com.fsd.pm.service.model.User;


public interface UserService {
	
	public User getUser(Long id);
	
	public User adduser(User user);

}
