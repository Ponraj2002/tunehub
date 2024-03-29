package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;
@Service
public class PlaylistServiceImplementation implements PlaylistService{
@Autowired
PlaylistRepository repo; 
	public void addPlaylist(Playlist playlist) {
		repo.save(playlist);
		
	}
	public List<Playlist> fetchAllPlaylists() {
		
		return repo.findAll();
	}

	
}
