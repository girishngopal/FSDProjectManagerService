package com.fsd.pm.service.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.pm.service.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
}
