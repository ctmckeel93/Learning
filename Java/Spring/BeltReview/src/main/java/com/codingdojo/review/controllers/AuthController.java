package com.codingdojo.review.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.review.models.User;
import com.codingdojo.review.services.AuthService;
import com.codingdojo.review.validator.UserValidator;

@Controller
public class AuthController {

	private final AuthService service;
	private final UserValidator validator;
	private final String[] states;
	
	public AuthController(AuthService service, UserValidator valid) {
		this.service = service;
		this.validator = valid;
		this.states = new String[]{"FL", "VA", "TX", "CA", "NC"};
	}
	
	@RequestMapping("/")
	public String register(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("states", states);
		return "/auth/register.jsp";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "/auth/register.jsp";
		}
		else {
			service.register(user);
			session.setAttribute("logged_in", user.getId());
			return "redirect:/home";
		}
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		return "/auth/login.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String reviewenticate(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
			
			boolean isValid = service.authenticate(email, password);
			if (isValid) {
				User user = service.findByEmail(email);
				session.setAttribute("logged_in", user.getId() );
				return "redirect:/home";
			}
			else {
				model.addAttribute("error", "Invalid login");
				return "/auth/login.jsp";
			}
	}
	
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
