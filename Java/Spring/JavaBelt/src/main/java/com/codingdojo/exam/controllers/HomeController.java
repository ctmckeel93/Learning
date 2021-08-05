package com.codingdojo.exam.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.exam.models.StorePackage;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.services.AuthService;
import com.codingdojo.exam.services.PackageService;

@Controller
public class HomeController {
	
	private final PackageService service;
	private final AuthService auth;
	
	public HomeController(PackageService service, AuthService auth) {
		this.service = service;
		this.auth = auth;
	}
	
	
	
	@PostMapping("/packages")
	public String newPackage(Principal principal,@Valid @ModelAttribute("package") StorePackage p, BindingResult result, Model model) {
		if (result.hasErrors()) {
			String email = principal.getName();
	        List<User> customers = auth.allUsers();
	        List<StorePackage> packages = service.allPackages();
	        model.addAttribute("currentUser", auth.findUserByEmail(email));
	        model.addAttribute("customers", customers);
	        model.addAttribute("packages", packages);
			return "admin.jsp";
		}
		else {
			service.createPackage(p);
			return "redirect:/admin";
		}
	}
	
	@GetMapping("/admin/packages/{id}/edit")
	public String editPackage(@PathVariable("id") Long id,@ModelAttribute("package") StorePackage p, Model model) {
		StorePackage pkg = service.findPackage(id);
		model.addAttribute("pkg",pkg);
		return "edit.jsp";
	}
	
	@PutMapping("/packages/{id}/edit")
	public String changePrice(@PathVariable("id") Long id, @Valid @ModelAttribute("package") StorePackage p, BindingResult result) {
		StorePackage pkg = service.findPackage(id);
		
//		if (result.hasErrors()) {
//			return "admin.jsp";
//		}
		pkg.setPrice(p.getPrice());
		service.updatePackage(pkg);
		return "redirect:/admin";
		
	}
	
	@PutMapping("/users/packages/{id}")
	public String changePackage(@PathVariable("id") Long id,@Valid @ModelAttribute("user") User user) {
		User updatedUser = auth.findUserById(id);
		updatedUser.setUserPackage(user.getUserPackage());
		auth.updateUser(updatedUser);
		return "redirect:/home";
	}
	
	@DeleteMapping("/packages/{id}/delete")
	public String removePackage(@PathVariable("id") Long id) {
		service.deletePackage(id);
		return "redirect:/admin";
	}

}
