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

import com.fsd.pm.service.model.Task;
import com.fsd.pm.service.modelservice.impl.TaskServiceImpl;
import com.fsd.pm.service.persistence.TaskRepository;

@RunWith(SpringRunner.class)
public class TaskServiceImplTest {

	

	@Mock
	TaskRepository taskRepository;
	
	@InjectMocks
	TaskServiceImpl taskServiceImpl = new TaskServiceImpl();

	
	
	@Test
	public void getAllTasksTest() throws Exception {
		List<Task> tlist = new ArrayList<>();
		Task t = new Task();
		t.setTaskName("taskname");
		Task t2 = new Task();
		t2.setTaskName("taskname2");
		tlist.add(t);
		tlist.add(t2);
		when(taskRepository.findAll()).thenReturn(tlist);
		List<Task> resulttasks = taskServiceImpl.getAllTasks();
		assertEquals(resulttasks.get(0).getTaskName(), "taskname");
		assertEquals(resulttasks.get(1).getTaskName(), "taskname2");
			
					
	}
	
	@Test
	public void addUpdateTaskTest() throws Exception {
		Task t = new Task();
		t.setTaskName("taskname");
		
		
		when(taskRepository.save(t)).thenReturn(t);
		Task result  = taskServiceImpl.addUpdateTask(t);
		assertEquals(result.getTaskName(), "taskname");
			
					
	}

}
