package com.fsd.pm.service.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fsd.pm.service.model.User;
import com.fsd.pm.service.modelservice.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userservice;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		List<User> users  = new ArrayList<User>();
		User user1 = new User();
		user1.setFirstName("firstName1");
		user1.setLastName("lastName1");
		
		User user2 = new User();
		user2.setFirstName("firstName2");
		user2.setLastName("lastName2");
		when(userservice.getAllUsers()).thenReturn(users);
		this.mockMvc.perform(get("/user/getUser/1"))			
			.andExpect(status().isOk())
			.andExpect(jsonPath("$",hasSize(2)))
			.andExpect(jsonPath("$[0].firstName",is("firstName"))); 
			
					
	}

}
