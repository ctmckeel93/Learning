package com.codingdojo.hellohuman;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
	
	
	@RequestMapping("/")
	public String Name(@RequestParam(value="name", required=false) String query) {
		
		if (query == null) {
			query = "Human";
		}
		return "<h1>" + "Hello " + query + "</h1> <h3>Welcome to Spring Boot</h3>"; 
	}

}
