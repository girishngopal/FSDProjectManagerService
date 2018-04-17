package com.fsd.pm.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.pm.service.model.User;
import com.fsd.pm.service.modelservice.UserService;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	@PostMapping(path="/updateUser") // Map ONLY GET Requests
	public  String updateUser (@RequestBody  User user) {				
		userService.addUpdateUser(user);
		return "Saved";
	}
	
	
	
	@GetMapping(path="/getAllUsers") // Map ONLY GET Requests
	public List<User> getAllUsers () {
		List<User> users= userService.getAllUsers();	  
		return users;
	}
	
	

}
