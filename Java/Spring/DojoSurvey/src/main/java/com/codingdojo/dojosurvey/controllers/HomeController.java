package com.codingdojo.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String Index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String Info(@RequestParam("name") String name, @RequestParam("location") String location, @RequestParam("language") String language, @RequestParam("comment") String comment, Model model) {
		
		
		model.addAttribute("Name", name);
		model.addAttribute("Location",location);
		model.addAttribute("Language", language);
		model.addAttribute("Comment", comment);
		return "info.jsp";
	}
	
}
