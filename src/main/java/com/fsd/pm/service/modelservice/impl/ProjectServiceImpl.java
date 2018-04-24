package com.fsd.pm.service.modelservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.pm.service.model.Project;
import com.fsd.pm.service.modelservice.ProjectService;
import com.fsd.pm.service.persistence.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	

	public List<Project> getAllProjects() {
		List<Project> projects = projectRepository.findAll();
		return projects;
	}

	public Project addUpdateProject(Project project) {

		return projectRepository.save(project);
	}

	

	
}
