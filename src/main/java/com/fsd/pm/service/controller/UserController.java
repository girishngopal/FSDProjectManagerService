package com.fsd.pm.service.controller;

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
	
	
	
	@PostMapping(path="/addUser") // Map ONLY GET Requests
	public  String addNewUser (@RequestBody  User user) {				
		userService.adduser(user);
		return "Saved";
	}
	
	@GetMapping(path="/getUser/{id}") // Map ONLY GET Requests
	public User getUser (@PathVariable("id") long id) {
		User user= userService.getUser(id);		  
		return user;
	}

}
