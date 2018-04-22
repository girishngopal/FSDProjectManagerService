package com.fsd.pm.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String firstName;

	String lastName;

	Long emloyeeId;

	@ManyToOne
	Project project;

	@ManyToOne
	Task task;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getEmloyeeId() {
		return emloyeeId;
	}

	public void setEmloyeeId(long emloyeeId) {
		this.emloyeeId = emloyeeId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	
//, @JsonProperty("project") Project project, @JsonProperty("task") Task task
	 @JsonCreator
	public User(@JsonProperty("id") Long id, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("emloyeeId") Long emloyeeId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emloyeeId = emloyeeId;
		/*this.project = project;
		this.task = task;*/
	}
	 
	 

}
