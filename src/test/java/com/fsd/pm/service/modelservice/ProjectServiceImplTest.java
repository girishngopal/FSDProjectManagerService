package com.fsd.pm.service.modelservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsd.pm.service.model.Project;
import com.fsd.pm.service.modelservice.impl.ProjectServiceImpl;
import com.fsd.pm.service.persistence.ProjectRepository;

@RunWith(SpringRunner.class)
public class ProjectServiceImplTest {

	

	@Mock
	ProjectRepository projectRepository;
	
	@InjectMocks
	ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl();

	
	
	@Test
	public void getAllProjectsTest() throws Exception {
		List<Project> plist = new ArrayList<>();
		Project p1 = new Project();
		p1.setProjectName("project");
		Project p2 = new Project();
		p2.setProjectName("project1");
		plist.add(p1);
		plist.add(p2);
		
		when(projectRepository.findAll()).thenReturn(plist);
		List<Project> resultprojects = projectServiceImpl.getAllProjects();
		assertEquals(resultprojects.get(0).getProjectName(), "project");
		assertEquals(resultprojects.get(1).getProjectName(), "project1");
			
					
	}
	
	@Test
	public void addUpdateProjectTest() throws Exception {
		Project p1 = new Project();
		p1.setProjectName("project");
		
		
		when(projectRepository.save(p1)).thenReturn(p1);
		Project resultp1  = projectServiceImpl.addUpdateProject(p1);
		assertEquals(resultp1.getProjectName(), "project");
			
					
	}

}
