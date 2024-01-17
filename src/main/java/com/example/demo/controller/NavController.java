package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class NavController {
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	@GetMapping("/registeration")
	public String registration()
	{
		return "registeration";
	}
	@GetMapping("/newSong")
	public String newSong()
	{
		return "newSong";
	}

}
