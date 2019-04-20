package com.abhishek.example.restfulwebservice.users;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="User Api Details")
public class User {

	private int id;
	
	@ApiModelProperty(notes="Name should be atleast 2 characters")
	@Size(min=2, message="Name should be atleast 2 characters")
	private String name;
	
	
	@Past
	@ApiModelProperty(notes="Birthdate should be in the past")
	private Date dob;
	
	public User() {
		
	}
	
	public User(int id, String name, Date dob) {
		super();
		this.id=id;
		this.name = name;
		this.dob = dob;
	}

	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}
