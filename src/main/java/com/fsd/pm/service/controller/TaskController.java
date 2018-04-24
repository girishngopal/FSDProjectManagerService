package com.fsd.pm.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.pm.service.model.ParentTask;
import com.fsd.pm.service.model.Project;
import com.fsd.pm.service.model.Task;
import com.fsd.pm.service.model.User;
import com.fsd.pm.service.modelservice.TaskService;
import com.fsd.pm.service.view.model.TaskModel;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping(path="/updateUser") 
	public String updateUser(@RequestBody TaskModel taskModel) {
		Task task=new Task();
		if(null!=taskModel.getTaskId()) {
			task.setTaskId(taskModel.getTaskId());
		}
		if(null!=taskModel.getProjectId()) {
			Project project = new Project();
			project.setProjectId(taskModel.getProjectId());
			task.setProject(project);
		}
		if(null!=taskModel.getParentId()) {
			ParentTask parentTask = new ParentTask();
			parentTask.setId(taskModel.getParentId());
			task.setParentTask(parentTask);			
		}
		if(null!=taskModel.getUserId()) {
			User user = new User();
			user.setUserId(taskModel.getUserId());
			task.setUser(user);
		}
		if(null!=taskModel.getTaskName()) {
			task.getTaskName();
		}
		if(null!=taskModel.getStartDate()) {
			
		}
		
		taskService.addUpdateTask(task);
		return "Saved";
	}

	@GetMapping(path = "/getAllTasks")
	public List<Task> getAllTasks() {
		List<Task> tasks = taskService.getAllTasks();
		return tasks;
	}

}
