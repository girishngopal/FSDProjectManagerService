package com.fsd.pm.service.controller;

import java.util.ArrayList;
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
import com.fsd.pm.service.modelservice.ParentTaskService;
import com.fsd.pm.service.modelservice.TaskService;
import com.fsd.pm.service.view.model.TaskModel;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private ParentTaskService parentTaskService;

	@PostMapping(path = "/updateTask")
	public String updateUser(@RequestBody TaskModel taskModel) {
		Task task = new Task();
		if (null != taskModel.getTaskId()) {
			task.setTaskId(taskModel.getTaskId());
		}
		if (null != taskModel.getProjectId()) {
			Project project = new Project();
			project.setProjectId(taskModel.getProjectId());
			task.setProject(project);
		}

		if (null != taskModel.getUserId()) {
			User user = new User();
			user.setUserId(taskModel.getUserId());
			task.setUser(user);
		}
		if (null != taskModel.getTaskName()) {
			task.setTaskName(taskModel.getTaskName());
		}
		if (null != taskModel.getStartDate()) {
			task.setStartDate(taskModel.getStartDate());
		}
		if (null != taskModel.getEndDate()) {
			task.setEndDate(taskModel.getEndDate());
		}
		if (null != taskModel.getPriority()) {
			task.setPriority(taskModel.getPriority());
		}
		if (null != taskModel.getStatus()) {
			task.setStatus(taskModel.getStatus());
		}
		if (null == taskModel.getParentId()) {
			ParentTask parentTask = new ParentTask();
			parentTask.setParentName(taskModel.getTaskName());
			task.setParentTask(parentTask);
			parentTaskService.addUpdateParentTask(parentTask);
		} else {
			ParentTask parentTask = new ParentTask();
			task.setParentTask(parentTask);			
		}
		taskService.addUpdateTask(task);
		return "Saved";
	}

	@GetMapping(path = "/getAllParentTasks")
	public List<ParentTask> getAllParentTasks() {
		return parentTaskService.getallParentTasks();
	}

	@GetMapping(path = "/getAllTasks")
	public List<TaskModel> getAllTasks() {
		List<Task> tasks = taskService.getAllTasks();
		List<TaskModel> tmlist = new ArrayList<TaskModel>();
		for (Task t : tasks) {
			TaskModel tm = new TaskModel();
			tm.setEndDate(t.getEndDate());
			tm.setStartDate(t.getStartDate());
			tm.setParentId(t.getParentTask().getParentId());
			tm.setParentName(t.getParentTask().getParentName());
			tm.setPriority(t.getPriority());
			tm.setStatus(t.getStatus());
			tm.setUserId(t.getUser().getUserId());
			tm.setTaskId(t.getTaskId());
			tm.setTaskName(t.getTaskName());
			tm.setProjectId(t.getProject().getProjectId());
			tm.setProjectName(t.getProject().getProjectName());
			tmlist.add(tm);
		}
		return tmlist;
	}

}