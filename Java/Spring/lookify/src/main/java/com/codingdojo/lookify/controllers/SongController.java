package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class SongController {

	private final SongService service;
	
	public SongController(SongService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Song> allSongs = service.allSongs();
		model.addAttribute("songs", allSongs);
		return "/songs/index.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/songs/new.jsp";
	}
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/songs/new.jsp";
		}
		else {
			service.createSong(song);
			return "redirect:/";			
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = service.findSong(id);
		if (song != null) {
			model.addAttribute("song", song);
			return "songs/show.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
	
	@RequestMapping("/songs/{id}/edit") 
	public String edit(@PathVariable("id") Long id, Model model) {
		Song song = service.findSong(id);
		model.addAttribute("song", song);
		return "/songs/edit.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/songs/edit.jsp";
		}
		else {
			service.updateSong(song);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		service.deleteSong(id);
		return "redirect:/";
	}
	
}
