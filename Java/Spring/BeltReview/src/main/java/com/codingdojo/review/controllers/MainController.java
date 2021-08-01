package com.codingdojo.review.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.review.models.Event;
import com.codingdojo.review.models.Message;
import com.codingdojo.review.models.User;
import com.codingdojo.review.services.MainService;

@Controller
public class MainController {
	
	private final MainService service;
	private final String[] states;
	
	public MainController(MainService service) {
		this.service = service;
		this.states = new String[]{"FL", "VA", "TX", "CA", "NC"};
	}
	
	@RequestMapping("/home")
	public String home(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		if (session.getAttribute("logged_in") == null) {
			return "redirect:/";
		}
		User user = service.findUserById((Long)session.getAttribute("logged_in"));
		List<Event> local = service.findByState(user.getState());
		List<Event> notLocal = service.findAllNotInState(user.getState());
		model.addAttribute("user", user);
		model.addAttribute("eventsInState", local );
		model.addAttribute("eventsNotInState", notLocal);
		model.addAttribute("states", states);
		return "home.jsp";
		
	}
	
	@RequestMapping(value="/events", method=RequestMethod.POST)
	public String schedule(@Valid @ModelAttribute("event") Event event, BindingResult result) {
		if (result.hasErrors()) {
			return "home.jsp";
		}
		else {
			service.createEvent(event);
			return "redirect:/home";
		}
	}
	
	@RequestMapping("/events/{id}")
	public String viewEvent(@PathVariable("id") Long id,@ModelAttribute("message") Message message, Model model, HttpSession session) {
		User user = service.findUserById((Long)session.getAttribute("logged_in"));
		Event e = service.findEvent(id);
		model.addAttribute("event", e);
		model.addAttribute("user", user);
		return "event.jsp";
	}
	
	@RequestMapping(value="/messages", method=RequestMethod.POST)
	public String comment(@Valid @ModelAttribute("message") Message msg, BindingResult result) {
		if(result.hasErrors()) {
			return "events.jsp";
		}
		else {
			service.createMessage(msg);
			return "redirect:/events/" + msg.getEvent().getId();
		}
	}
	
	@RequestMapping("/events/{id}/edit")
	public String edit(@PathVariable("id") Long id,@ModelAttribute("event") Event e, Model model, HttpSession session) {
		Long userId =  (Long) session.getAttribute("logged_in");
		User user = service.findUserById(userId);
		Event event = service.findEvent(id);
		model.addAttribute("event", event);
		model.addAttribute("user", user);
		model.addAttribute("states", states);
		return "editEvent.jsp";
	}
	
	@RequestMapping(value="/events/{id}", method=RequestMethod.PUT)
	public String processEdit(@Valid @ModelAttribute("event") Event e, BindingResult result) {
		if (result.hasErrors()) {
			return "editEvent.jsp";
		}else {
			service.updateEvent(e);
			return "redirect:/events/" + e.getId();
		}
	}
	
	@RequestMapping("/events/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Event e = service.findEvent(id);
		Long userId = (Long)session.getAttribute("logged_in");
		User user = service.findUserById(userId);
		service.addToUserEvents(user, e);
		return "redirect:/home";
	}
	
	@DeleteMapping("/events/{id}/delete")
	public String cancelEvent(@PathVariable("id") Long id) {
		service.deleteEventById(id);
		return "redirect:/home";
	}

	
	
}
