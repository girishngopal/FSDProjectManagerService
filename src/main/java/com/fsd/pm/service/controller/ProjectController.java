package com.fsd.pm.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.pm.service.model.Project;
import com.fsd.pm.service.modelservice.ProjectService;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping(path = "/updateProject") // Map ONLY GET Requests
	public String updateProject(@RequestBody Project project) {
		projectService.addUpdateProject(project);
		return "Saved";
	}

	@GetMapping(path = "/getAllProjects") // Map ONLY GET Requests
	public List<Project> getAllProjects() {
		List<Project> projects = projectService.getAllProjects();
		return projects;
	}

}
