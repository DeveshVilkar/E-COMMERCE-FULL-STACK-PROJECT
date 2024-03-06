package com.jsp.ECommerce.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ECommerce.exception.NoSuchUserFoundException;
import com.jsp.ECommerce.model.LogIn;
import com.jsp.ECommerce.model.ResponseStructure;
import com.jsp.ECommerce.model.User;
import com.jsp.ECommerce.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/user/login")
	public ResponseStructure<User> validateUser(@RequestBody LogIn logIn){
		return userService.validateUser(logIn.getEmail(), logIn.getPassword());
		
	}
	
	@PostMapping("/user")
	public ResponseStructure<User> createUser(@RequestBody User user){
		return userService.createUser(user);
	}
	
	@GetMapping("/user/{id}")
	public ResponseStructure<User> getUserById(@PathVariable int id) throws NoSuchUserFoundException{
		return userService.getUserById(id);
		
	}
	
	@DeleteMapping("/user/{id}")
	public boolean deleteUserById(@PathVariable int id) {
		return userService.deleteUser(id);
	}
	
	@PutMapping("/user/{id}")
	public User updateUserById(@PathVariable int id,@RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userService.listUser();
	}
	

}
