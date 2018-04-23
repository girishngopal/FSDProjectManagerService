package com.fsd.pm.service.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fsd.pm.service.model.User;
import com.fsd.pm.service.modelservice.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	User mockUser = new User();


	String exampleUser = "{\"id\": 2,\"firstName\": \"asw\",\"lastName\":\"gopal\"}";
	
	@Test
	public void retrieveUser(){
		Mockito.when(userService.getUser(Mockito.anyLong())).thenReturn(mockUser);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/user/getUser/2").accept(
				MediaType.APPLICATION_JSON);
	}

}
