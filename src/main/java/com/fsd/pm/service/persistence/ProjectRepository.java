package com.fsd.pm.service.persistence;

import org.springframework.data.repository.CrudRepository;

import com.fsd.pm.service.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
}
