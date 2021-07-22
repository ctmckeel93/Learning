package com.codingdojo.routing;
import org.springframework.web.bind.annotation.*;

@RestController
public class DojoController {
	
	@RequestMapping("/dojo")
	public String Dojo() {
		
		return "The dojo is awesome";
		
	}
	
	@RequestMapping("/burbank-dojo") 
	public String Burbank() {
		return "Burbank Dojo is located in Southern California";
	}
	
	@RequestMapping("/san-jose")
	public String SanJose() {
		return "SJ Dojo is the headquarters";
	}
}
	

