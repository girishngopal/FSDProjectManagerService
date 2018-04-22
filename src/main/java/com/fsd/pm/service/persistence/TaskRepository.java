package com.fsd.pm.service.persistence;

import org.springframework.data.repository.CrudRepository;

import com.fsd.pm.service.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
	
}
