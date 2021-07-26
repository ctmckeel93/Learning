package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/counter")
	public String Index(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer counter = (Integer) session.getAttribute("count");
			counter++;
			session.setAttribute("count", counter);
		}
		model.addAttribute("visit_count", session.getAttribute("count"));
		return "index.jsp";
	}
}
