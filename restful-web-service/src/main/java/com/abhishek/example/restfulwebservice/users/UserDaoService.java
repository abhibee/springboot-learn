package com.abhishek.example.restfulwebservice.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	static List<User> users = new ArrayList<>();
	static int count=4;
	
	static {
		users.add(new User(1,"Adam", new Date()));
		users.add(new User(2,"Eve", new Date()));
		users.add(new User(3,"Shally", new Date()));
		users.add(new User(4,"Nikole", new Date()));
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User getUser(int i) {
		for(User user:users) {
			if(user.getId()==i) return user;
		}
		return null;
		
	}
	
	public User deleteUser(int i) {
		for(User user:users) {
			if(user.getId()==i) {
				users.remove(user);
				return user;
			}
		}
		return null;
		
	}
	
	public User createUser(User userobj) {
		User user=new User(++count, userobj.getName(), userobj.getDob()); 
		users.add(user);
		return user;
		
	}
	
}
