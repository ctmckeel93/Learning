package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository repo;
	
	public SongService(SongRepository repo) {
		this.repo = repo;
	}
	
	public List<Song> allSongs() {
		return repo.findAll();
	}
	
	public Song createSong(Song song) {
		return repo.save(song);
	}
	
	public Song findSong(Long id) {
		Optional<Song> song = repo.findById(id);
		if (song.isPresent()) {
			return song.get();
		}
		else {
			return null;
		}
	}
	
	public Song updateSong(Song song) {
		Optional<Song> opt = repo.findById(song.getId());
		if (opt.isPresent()) {
			Song songToUpdate = opt.get();
			songToUpdate.setTitle(song.getTitle());
			songToUpdate.setArtist(song.getArtist());
			songToUpdate.setRating(song.getRating());
		
			return repo.save(songToUpdate);
		}
		else {
			return null;
		}
	}
	
	public void deleteSong(Long id) {
		repo.deleteById(id);
	}

}
