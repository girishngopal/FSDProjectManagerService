package com.fsd.pm.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ParentTask {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
	
	@ManyToOne
	Task childTask;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Task getChildTask() {
		return childTask;
	}

	public void setChildTask(Task childTask) {
		this.childTask = childTask;
	}
}
