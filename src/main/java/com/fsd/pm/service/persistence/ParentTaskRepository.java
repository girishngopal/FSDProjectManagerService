package com.fsd.pm.service.persistence;

import org.springframework.data.repository.CrudRepository;

import com.fsd.pm.service.model.ParentTask;

public interface ParentTaskRepository extends CrudRepository<ParentTask, Long> {
	
}
