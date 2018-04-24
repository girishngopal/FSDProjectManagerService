package com.fsd.pm.service.modelservice;

import java.util.List;

import com.fsd.pm.service.model.Project;

public interface ProjectService {

	public Project addUpdateProject(Project project);

	public List<Project> getAllProjects();

}
