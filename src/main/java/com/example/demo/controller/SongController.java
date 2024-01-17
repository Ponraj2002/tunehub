package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;
@Controller
public class SongController {
	@Autowired
	SongService service;
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song)
	{
		boolean songStatus=service.songExists(song.getName());
		if(songStatus==false)
		{
			
		
		service.addSong(song);
		System.out.println("Song added succsessfully");
		}
		else
		{
			System.out.println("song alredy exists");
		}
		return "adminhome";
	}
	@GetMapping("/viewSongs")
	public String viewSongs(Model model)
	{
		List<Song> songsList=service.fetchAllSongs();
		System.out.println(songsList);
		model.addAttribute("songs",songsList);
		return "displaySongs";
	}
	
@GetMapping("/playSongs")
public String playSongs(Model model)
{
	boolean premiumUser=false;
	if(premiumUser == true)
	{
		List<Song> songList=service.fetchAllSongs();
		model.addAttribute("songs",songList);
		return"displaySongs";
		}
	else
	{
		return "makePayment";
	}
}
}
