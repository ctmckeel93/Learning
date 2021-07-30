package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;

@Controller
public class HomeController {

	private final DojoService dservice;
	private final NinjaService nservice;
	
	public HomeController(DojoService ds, NinjaService ns) {
		this.dservice = ds;
		this.nservice = ns;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Dojo> dojos = dservice.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/newDojo.jsp";
	}
	
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		dservice.createDojo(dojo);
		return "redirect:/";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dservice.allDojos();
		model.addAttribute("dojos", dojos);
		return "/ninjas/newNinja.jsp"; 
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String join(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		nservice.createNinja(ninja);
		return "redirect:/";
	}
	
	@RequestMapping("/dojos/{id}/ninjas")
	public String dojoNinjas(@PathVariable("id") Long id,Model model) {
		Dojo dojo = dservice.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojoNinjas.jsp";
	}
}
