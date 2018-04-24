package com.fsd.pm.service.modelservice;

import java.util.List;

import com.fsd.pm.service.model.Task;

public interface TaskService {

	public Task addUpdateTask(Task task);

	public List<Task> getAllTasks();

}
