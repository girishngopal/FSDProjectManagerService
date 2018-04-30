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

import com.fsd.pm.service.model.ParentTask;
import com.fsd.pm.service.modelservice.impl.ParentTaskServiceImpl;
import com.fsd.pm.service.persistence.ParentTaskRepository;

@RunWith(SpringRunner.class)
public class ParentTaskServiceImplTest {

	

	@Mock
	ParentTaskRepository parentTaskRepository;
	
	@InjectMocks
	ParentTaskServiceImpl parentTaskServiceImpl = new ParentTaskServiceImpl();

	
	
	@Test
	public void getAllTasksTest() throws Exception {
		List<ParentTask> ptlist = new ArrayList<>();
		ParentTask t = new ParentTask();
		t.setParentName("taskname");
		
		ParentTask t1 = new ParentTask();
		t1.setParentName("taskname1");
		ptlist.add(t);
		ptlist.add(t1);
		when(parentTaskRepository.findAll()).thenReturn(ptlist);
		List<ParentTask> resultlist = parentTaskServiceImpl.getallParentTasks();
		assertEquals(resultlist.get(0).getParentName(), "taskname");
		assertEquals(resultlist.get(1).getParentName(), "taskname1");
			
					
	}
	
	@Test
	public void addUpdateTaskTest() throws Exception {
		ParentTask t = new ParentTask();
		t.setParentName("taskname");
		
		
		when(parentTaskRepository.save(t)).thenReturn(t);
		ParentTask result  = parentTaskServiceImpl.addUpdateParentTask(t);
		assertEquals(result.getParentName(), "taskname");
			
					
	}

}