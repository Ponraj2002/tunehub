package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.*;



@Controller
public class UsersController {
	@Autowired
	UsersService service;
	
	
 @PostMapping("/registeration")
 public String addUser(@ModelAttribute Users user) 
 {
	 boolean userStatus=service.emailExists(user.getEmail());
	 if(userStatus == false)
	 {
	 service.addUser(user);
	 System.out.println("user added");
	 }
	 else {
		 System.out.println("useralready exists");
	 }
	 return "home";	 
 }
 @PostMapping("/validate")
 public String validate(@RequestParam("email") String email,@RequestParam ("password")String password,
		 HttpSession session)
 {
if(service.validateUser(email,password)==true)
{
	String role=service.getRole(email);
	session.setAttribute("email",email);
	if(role.equals("admin"))
	{
		return "adminhome";
	}
	else
	{
		return "customerhome";
	}
}
else
{
	return"login";
}

 }
 
@GetMapping("/logout")
public String logout(HttpSession session)
{
	session.invalidate();
	return "login";
}
}