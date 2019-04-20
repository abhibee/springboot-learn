package com.abhishek.example.restfulwebservice.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDao;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return userDao.getAllUsers();		
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> getUser(@PathVariable int id){
		User user= userDao.getUser(id);
		if (user==null)
			throw new UserNotFoundException(String.format("UserId: %s", id));

		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
				methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user= userDao.deleteUser(id);
		if (user==null)
			throw new UserNotFoundException(String.format("UserId: %s", id));
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
	User savedUser = userDao.createUser(user);
	
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
	return ResponseEntity.created(uri).build();
	}
	
}
