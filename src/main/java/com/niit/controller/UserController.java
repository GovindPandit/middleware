package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.User;
import com.niit.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{	
	@Autowired
	UserService userService;
	
	@GetMapping("/display")
	//@ResponseBody
	public ResponseEntity<List<User>> getUsers()
	{
		return new ResponseEntity<List<User>>(userService.displayUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/display/{userid}")
	//@ResponseBody
	public ResponseEntity<User> getUserById(@PathVariable("userid") int userid)
	{
		return new ResponseEntity<User>(userService.displayUserById(userid),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> addUser(@RequestBody User user)
	{
		userService.addUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userid") int userid )
	{
		userService.deleteUser(userid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> updateUser(@RequestBody User user)
	{
		userService.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
