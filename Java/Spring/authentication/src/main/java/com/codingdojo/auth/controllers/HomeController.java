package com.codingdojo.auth.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.auth.models.User;
import com.codingdojo.auth.services.UserService;
import com.codingdojo.auth.validator.UserValidator;

@Controller
public class HomeController {

	private final UserService service;
	private final UserValidator validator;
	
	public HomeController(UserService service, UserValidator valid) {
		this.service = service;
		this.validator = valid;
	}
	
	@RequestMapping("/")
	public String register(@ModelAttribute("user") User user) {
		return "register.jsp";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "register.jsp";
		}
		else {
			service.register(user);
			session.setAttribute("logged_in", user.getId());
			return "redirect:/home";
		}
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		return "login.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
			
			boolean isValid = service.authenticate(email, password);
			if (isValid) {
				User user = service.findByEmail(email);
				session.setAttribute("logged_in", user.getId() );
				return "redirect:/home";
			}
			else {
				model.addAttribute("error", "Invalid login");
				return "login.jsp";
			}
	}
	
	@RequestMapping("/home")
	public String home(Model model, HttpSession session) {
		if (session.getAttribute("logged_in") == null) {
			return "redirect:/";
		}
		User user = service.findUserById((Long)session.getAttribute("logged_in"));
		model.addAttribute("user", user);
		return "home.jsp";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
