package com.codingdojo.overflow.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.models.User;
import com.codingdojo.overflow.services.UserService;
import com.codingdojo.overflow.validator.UserValidator;

@Controller
public class UserController {

	private final UserService service;
	private final UserValidator validator;
	
	public UserController(UserService service, UserValidator valid) {
		this.service = service;
		this.validator = valid;
	}
	
	@RequestMapping("/")
	public String register(@ModelAttribute("user") User user) {
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
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		return "/auth/login.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
			
			boolean isValid = service.authenticate(email, password);
			if (isValid) {
				User user = service.findByEmail(email);
				session.setAttribute("logged_in", user.getId() );
				return "redirect:/dashboard";
			}
			else {
				model.addAttribute("error", "Invalid login");
				return "/auth/login.jsp";
			}
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question q) {
		return "questionForm.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
