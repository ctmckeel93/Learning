package com.codingdojo.codebreaker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String Index() {
		
		return "index.jsp";
		
	}
	
	@RequestMapping(value="/unlock", method=RequestMethod.POST) 
	public String Unlock(@RequestParam("code") String code, RedirectAttributes flash) {
		
		String secret = "bushido";
		
		if (code.equals(secret)) {			
			return "redirect:/code";
		}
		flash.addFlashAttribute("error", "You must train more");
		return "redirect:/";
		
		
	}
	
	@RequestMapping("/code")
	public String Code() {
		return "code.jsp";
	}
}
