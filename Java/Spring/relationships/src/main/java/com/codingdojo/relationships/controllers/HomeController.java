package com.codingdojo.relationships.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class HomeController {
	
	private final PersonService pservice;
	private final LicenseService lservice;
	
	public HomeController(PersonService ps, LicenseService ls) {
		this.pservice = ps;
		this.lservice = ls;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Person> persons = pservice.allPersons();
		model.addAttribute("persons",persons);
		return "index.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person p) {
		
		return "/persons/new.jsp";
		
	}
	
	@RequestMapping(value="/persons", method=RequestMethod.POST)
	public String addPerson(@Valid @ModelAttribute("person") Person p, BindingResult result) {
		if (result.hasErrors()) {
			return "/persons/new.jsp";
		}
		else {
			pservice.createPerson(p);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping("/licenses/new") 
	public String newLicense(@ModelAttribute("license") License l, Model model) {
		List<Person> persons = pservice.allPersons();
		model.addAttribute("persons", persons);
		return "/licenses/new.jsp";
	}
	
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public String addLicense(@Valid @ModelAttribute("license") License l, BindingResult result) {
		lservice.createLicense(l);
		return "redirect:/";
	}
	
	@RequestMapping("/persons/{id}")
	public String viewPerson(@PathVariable("id") Long id, Model model) {
		Person p = pservice.findPerson(id);
		model.addAttribute("person", p);
		return "show.jsp";
	}
	
	
	

}
