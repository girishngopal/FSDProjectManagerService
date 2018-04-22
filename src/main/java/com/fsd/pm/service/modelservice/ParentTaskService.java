package com.fsd.pm.service.modelservice;


import java.util.List;

import com.fsd.pm.service.model.ParentTask;

public interface ParentTaskService {

	public ParentTask addUpdateParentTask(ParentTask parentTask);
	
	public List<ParentTask> getallParentTasks();


}