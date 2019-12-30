package com.niit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.User;

@Controller
@RequestMapping("/user")
public class UserController 
{	
	UserDAOImpl udi=new UserDAOImpl();
	
	@GetMapping("/display")
	@ResponseBody
	public List<User> getUsers()
	{
		return udi.displayUsers();
	}
	
	
	
}
