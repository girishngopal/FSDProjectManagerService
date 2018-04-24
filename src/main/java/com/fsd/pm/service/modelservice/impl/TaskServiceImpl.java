package com.fsd.pm.service.modelservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.pm.service.model.Project;
import com.fsd.pm.service.model.Task;
import com.fsd.pm.service.model.User;
import com.fsd.pm.service.modelservice.TaskService;
import com.fsd.pm.service.persistence.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	

	@Override
	public Task addUpdateTask(Task task) {		
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	

	
}
