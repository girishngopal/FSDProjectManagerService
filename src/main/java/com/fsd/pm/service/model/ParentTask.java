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
    Long parentId;
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	private String parentName;
	
	@ManyToOne
	Task childTask;

	

	public Task getChildTask() {
		return childTask;
	}

	public void setChildTask(Task childTask) {
		this.childTask = childTask;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
