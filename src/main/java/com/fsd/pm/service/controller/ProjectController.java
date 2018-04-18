package com.fsd.pm.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsd.pm.service.model.Project;
import com.fsd.pm.service.persistence.ProjectRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/project")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	
	
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser () {


		Project project = new Project();
		project.setProjectName("Demo");
		projectRepository.save(project);
		return "Saved";
	}

}
