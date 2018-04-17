package com.fsd.pm.service.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
	public void getAllUserWebTest() throws Exception {
		List<User> users  = new ArrayList<User>();
		User user1 = new User();
		user1.setUserId(1L);
		user1.setFirstName("firstName1");
		user1.setLastName("lastName1");
		
		User user2 = new User();
		user2.setUserId(2L);
		user2.setFirstName("firstName2");
		user2.setLastName("lastName2");
		users.add(user1);
		users.add(user2);
		when(userservice.getAllUsers()).thenReturn(users);
		this.mockMvc.perform(get("/user/getAllUsers"))			
			.andExpect(status().isOk())
			.andExpect(jsonPath("$",hasSize(2)))
			.andExpect(jsonPath("$[0].userId",is(1)))
			.andExpect(jsonPath("$[0].firstName",is("firstName1")))
			.andExpect(jsonPath("$[0].lastName",is("lastName1")))
			.andExpect(jsonPath("$[1].userId",is(2)))
			.andExpect(jsonPath("$[1].firstName",is("firstName2")))
			.andExpect(jsonPath("$[1].lastName",is("lastName2"))); 
			
					
	}
	
	@Test
	public void addUpdateUserWebTest() throws Exception {		
		User user1 = new User();
		user1.setUserId(1L);
		user1.setFirstName("firstName1");
		user1.setLastName("lastName1");
		String mockUser="{\"firstName\":\"firstName1\",\"lastName\":\"lastName1\"}";
		
		when(userservice.addUpdateUser(user1)).thenReturn(user1);
		this.mockMvc.perform(post("/user/updateUser")
				.accept(MediaType.APPLICATION_JSON)
				.content(mockUser)
				.contentType(MediaType.APPLICATION_JSON))		
			.andExpect(status().isOk());
			
					
	}

}
