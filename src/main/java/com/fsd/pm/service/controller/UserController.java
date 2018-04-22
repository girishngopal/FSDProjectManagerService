package com.fsd.pm.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.pm.service.model.User;
import com.fsd.pm.service.modelservice.UserService;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	/*@GetMapping(path="/addUser") // Map ONLY GET Requests
	public @ResponseBody String addNewUser () {
		User user = new User(null, "girish", "gopal", null);
		user.setFirstName("girish");
		user.setLastName("gopal");		
		userService.adduser(user);
		return "Saved";
	}*/
	
	@GetMapping(path="/getUser/{id}") // Map ONLY GET Requests
	public ResponseEntity<User> getUser (@PathVariable("id") long id) {
		User user= userService.getUser(id);
		System.out.println(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
