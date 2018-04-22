package com.fsd.pm.service.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fsd.pm.service.model.Project;
import com.fsd.pm.service.modelservice.ProjectService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProjectService projectService;

	@Test
	public void getAllProjectsTest() throws Exception {
		List<Project> prlist = new ArrayList<>();
		Project pr1 = new Project();
		pr1.setProjectName("project1");
		Project pr2 = new Project();
		pr2.setProjectName("project2");
		prlist.add(pr1);
		prlist.add(pr2);
		when(projectService.getAllProjects()).thenReturn(prlist);
		this.mockMvc.perform(get("/project/getAllProjects")).andExpect(status().isOk());
	}

	@Test
	public void updateProjectTest() throws Exception {
		Project pr1 = new Project();
		pr1.setProjectName("project1");
		when(projectService.addUpdateProject(pr1)).thenReturn(pr1);
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/project/updateProject")
				.contentType(MediaType.APPLICATION_JSON);
	}

}
