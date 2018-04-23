package com.fsd.pm.service.modelservice;

import java.util.List;

import com.fsd.pm.service.model.User;

public interface UserService {

	public User getUser(Long id);

	public User addUpdateUser(User user);

	public List<User> getAllUsers();

}
