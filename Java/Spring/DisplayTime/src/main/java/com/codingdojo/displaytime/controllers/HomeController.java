package com.codingdojo.displaytime.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String Index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String Date() {
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String Time() {
		return "time.jsp";	
	}

}
