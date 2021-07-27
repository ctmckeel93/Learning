package com.codingdojo.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.time.*;

@Controller
public class HomeController {
	public ArrayList<String> results =new ArrayList<String>(); 

	@RequestMapping("/")
	public String Index(HttpSession session, Model model) {
		
		if (session.getAttribute("gold") ==  null) {
			session.setAttribute("gold", 0);
		}
		model.addAttribute("results", results);
//		session.setAttribute("actionLog", results);
		
		
		
		return "index.jsp";
		
	}
	
	@RequestMapping(value="/find-gold", method=RequestMethod.POST)
	public String Find(@RequestParam("input") String input, HttpSession session, Model model) {
		Random rng = new Random();
		if (input.equals("farm") == true) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy HH:mm a");
			Date now = new Date(System.currentTimeMillis());
			String current = formatter.format(now);
			
			
			int value =rng.nextInt(20-10) + 10;
			Integer gold = (Integer) session.getAttribute("gold");
			
			results.add("You entered a farm and earned " + value + " gold. ( " + current + ")" );
			session.setAttribute("gold", gold + value);
		}
		
		if (input.equals("cave") == true) {
			SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy HH:mm a");
			Date now = new Date(System.currentTimeMillis());
			String current = formatter.format(now);
			
			
			int value =rng.nextInt(20-10) + 10;
			Integer gold = (Integer) session.getAttribute("gold");
			
			results.add("You entered a cave and earned " + value + " gold. ( " + current + ")" );
			session.setAttribute("gold", gold + value);
		}
		
		if (input.equals("house") == true) {
			SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy HH:mm a");
			Date now = new Date(System.currentTimeMillis());
			String current = formatter.format(now);
			
			
			int value =rng.nextInt(20-10) + 10;
			Integer gold = (Integer) session.getAttribute("gold");
			
			results.add("You entered a house and earned " + value + " gold. ( " + current + ")" );
			session.setAttribute("gold", gold + value);
		}
		
		if (input.equals("casino") == true) {
			SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy HH:mm a");
			Date now = new Date(System.currentTimeMillis());
			String current = formatter.format(now);
			
			int value =rng.nextInt(51);
			int sign = rng.nextInt(2);
			Integer gold = (Integer) session.getAttribute("gold");
			if (sign == 1) {				
				session.setAttribute("gold", gold + value);
				results.add("You entered a casino and won " + value + " gold. ( " + current + ")" );
			}
			else {
				session.setAttribute("gold",  gold - value);
				results.add("You entered a casino and lost " + value + " gold. ( " + current + ")" );
			}
		}
		return "redirect:/";
		
	}
}
