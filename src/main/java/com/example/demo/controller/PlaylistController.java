package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.entities.*;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;
	@Controller
public class PlaylistController {
	@Autowired
	SongService songService;
	@Autowired
	PlaylistService playlistService;
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model)
	{
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createPlaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		playlistService.addPlaylist(playlist);
		
		List<Song> songList=playlist.getSongs();
		for(Song s:songList)
		{
			s.getPlaylist().add(playlist);
			songService.updateSong(s);
			
		}
		return "adminHome";
	}
	@GetMapping("/displayPlaylists")
	public String displayPlaylists(Model model)
	{
		List<Playlist> allPlaylist=playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylists",allPlaylist);
		return "displayPlaylists";
	}


}
