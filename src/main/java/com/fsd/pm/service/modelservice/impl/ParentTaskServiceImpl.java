package com.fsd.pm.service.modelservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.pm.service.model.ParentTask;
import com.fsd.pm.service.modelservice.ParentTaskService;
import com.fsd.pm.service.persistence.ParentTaskRepository;

@Service
public class ParentTaskServiceImpl implements ParentTaskService {

	
	@Autowired
	ParentTaskRepository parentTaskRepository;
	
	@Override
	public ParentTask addUpdateParentTask(ParentTask parentTask) {
		return parentTaskRepository.save(parentTask);
	}

	@Override
	public List<ParentTask> getallParentTasks() {
		return (List<ParentTask>) parentTaskRepository.findAll();
		 
	}

	
	

	

	

	
}
