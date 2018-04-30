package com.fsd.pm.service.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fsd.pm.service.model.ParentTask;
import com.fsd.pm.service.model.Project;
import com.fsd.pm.service.model.Task;
import com.fsd.pm.service.model.User;
import com.fsd.pm.service.modelservice.ParentTaskService;
import com.fsd.pm.service.modelservice.TaskService;
import com.fsd.pm.service.view.model.TaskModel;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaskService taskService;

	@MockBean
	private ParentTaskService parentTaskService;

	@Test
	public void updateParentTaskTest() throws Exception {
		ParentTask pt = new ParentTask();
		pt.setParentName("ParentTask");
		Task t1 = new Task();
		t1.setTaskName("task1");
		when(parentTaskService.addUpdateParentTask(pt)).thenReturn(pt);
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/task/updateTask")
				.contentType(MediaType.APPLICATION_JSON);

	}
	
	@Test
	public void updateTaskTest() throws Exception {
		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(1L);
		taskModel.setProjectId(1L);
		taskModel.setUserId(1L);
		taskModel.setTaskName("Task1");
		Calendar now=Calendar.getInstance();
		taskModel.setStartDate(now.getTime());
		now.add(Calendar.DATE, 5);		
		taskModel.setStartDate(now.getTime());
		taskModel.setPriority(1);
		taskModel.setStatus(true);
		taskModel.setParentId(1L);		
		
		String mockTasjJson = "{\"taskId\":1,\"parentId\":1,\"projectId\":1,\"userId\":1,\"parentName\":null,\"projectName\":null,\"taskName\":\"Task1\",\"userName\":null,\"startDate\":1525534264159,\"endDate\":null,\"priority\":1,\"status\":true}";
		System.out.println(mockTasjJson);
		Task mockTask = new Task();
		mockTask.setTaskId(1L);
		Project mockProject = new Project();
		mockProject.setProjectId(1L);
		mockTask.setProject(mockProject);
		User mockUser = new User();
		mockUser.setUserId(1L);
		mockTask.setUser(mockUser);
		mockTask.setPriority(1);
		mockTask.setStatus(true);
		ParentTask mockParentTask = new ParentTask();
		mockParentTask.setParentId(1L);
		mockTask.setParentTask(mockParentTask);	
		when(taskService.addUpdateTask(mockTask)).thenReturn(mockTask);
		when(parentTaskService.addUpdateParentTask(mockParentTask)).thenReturn(mockParentTask);
		this.mockMvc.perform(post("/task/updateTask")
				.accept(MediaType.APPLICATION_JSON)
				.content(mockTasjJson)
				.contentType(MediaType.APPLICATION_JSON))		
			.andExpect(status().isOk());

	}
	
	

	@Test
	public void getAllParentTask() throws Exception {

		List<ParentTask> ptlist = new ArrayList<>();
		ParentTask pt = new ParentTask();
		pt.setParentName("ParentTask");
		ParentTask pt2 = new ParentTask();
		pt2.setParentName("ParentTask2");
		ptlist.add(pt);
		ptlist.add(pt2);
		when(parentTaskService.getallParentTasks()).thenReturn(ptlist);
		this.mockMvc.perform(get("/task/getAllParentTasks")).andExpect(status().isOk());

	}

	@Test
	public void getAllTasksTest() throws Exception {
		List<Task> tlist = new ArrayList<>();
		ParentTask pt = new ParentTask();
		pt.setParentName("parenttask");
		Project pr = new Project();
		pr.setProjectName("project");
		User user = new User();
		user.setFirstName("f");
		Task t1 = new Task();
		t1.setTaskName("task1");
		t1.setParentTask(pt);
		t1.setProject(pr);
		t1.setUser(user);
		Task t2 = new Task();
		t2.setTaskName("task2");
		t2.setParentTask(pt);
		t2.setProject(pr);
		t2.setUser(user);
		tlist.add(t1);																	
		tlist.add(t2);
		when(taskService.getAllTasks()).thenReturn(tlist);
		this.mockMvc.perform(get("/task/getAllTasks"));

	}

}
