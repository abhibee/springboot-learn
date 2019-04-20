package com.abhishek.example.restfulwebservice.helloworld;

public class HelloBean {

	private String message;

	public HelloBean(String string) {
		this.message = string;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HelloBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
