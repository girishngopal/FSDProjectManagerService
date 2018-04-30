package com.fsd.pm.service.modelservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsd.pm.service.model.User;
import com.fsd.pm.service.modelservice.impl.UserServiceImpl;
import com.fsd.pm.service.persistence.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl usservice = new UserServiceImpl();

	@Test
	public void getAllUsersTest() throws Exception {
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");

		User user2 = new User();
		user2.setFirstName("firstName2");
		user2.setLastName("lastName2");
		List<User> userlist = new ArrayList<User>();
		userlist.add(user);
		userlist.add(user2);
		when(userRepository.findAll()).thenReturn(userlist);
		List<User> resultUsers = usservice.getAllUsers();
		User resultUser1 = resultUsers.get(0);
		User resultUser2 = resultUsers.get(1);
		assertEquals(resultUser1.getFirstName(), "firstName");
		assertEquals(resultUser2.getFirstName(), "firstName2");

	}

	@Test
	public void addUpdateUserTest() throws Exception {
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");

		when(userRepository.save(user)).thenReturn(user);
		User resultUser = usservice.addUpdateUser(user);

		assertEquals(resultUser.getFirstName(), "firstName");

	}

}
