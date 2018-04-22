package com.fsd.pm.service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting  {

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