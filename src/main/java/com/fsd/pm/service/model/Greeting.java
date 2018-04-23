package com.fsd.pm.service.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Greeting  {
	@Id
	Long id;

	String firstName;

	String lastName;

	

    @JsonCreator
    public Greeting(@JsonProperty("firstName") String firstName) {
        this.firstName = firstName;
    }



	public String getfirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
    
}