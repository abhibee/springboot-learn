package com.abhishek.example.restfulwebservice.exception;

import java.util.Date;


public class ExceptionResponseTemplate {
	
	private String message;
	private Date time;
	private String description;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public ExceptionResponseTemplate(String message, Date time, String description) {
		super();
		this.message = message;
		this.time = time;
		this.description = description;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
