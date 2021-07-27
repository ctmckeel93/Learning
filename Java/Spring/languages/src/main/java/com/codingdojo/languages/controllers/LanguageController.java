package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	private final LanguageService service;
	
	public LanguageController(LanguageService service) {
		this.service = service;
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Language> allLanguages = service.allLanguages();
		model.addAttribute("languages", allLanguages);
		return "/languages/index.jsp";
	}
	
	@RequestMapping("/languages/new")
	public String newLanguage(@ModelAttribute("language") Language lang) {
		return "/languages/new.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/new.jsp";
		}
		else {
			service.createLanguage(lang);			
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language lang = service.findLanguage(id);
		model.addAttribute("language", lang);
		return "/languages/show.jsp";
	}
	
	@RequestMapping(value="/languages/{id}/edit") 
	public String edit(Model model, @PathVariable("id") Long id) {
		Language lang = service.findLanguage(id);
		model.addAttribute("lang",lang);
		return "/languages/edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("lang") Language lang, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/edit.jsp";
		}
		service.updateLanguage(lang);
		return "redirect:/languages";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		
		service.deleteLanguage(id);
		return "redirect:/languages";
		
	}

}
