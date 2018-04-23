package com.fsd.pm.service.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fsd.pm.service.controller.UserController;
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
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");
		when(userservice.getUser(Mockito.anyLong())).thenReturn(user);
		this.mockMvc.perform(get("/user/getUser/1"))			
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.firstName",is("firstName")));
			
					
	}

}
