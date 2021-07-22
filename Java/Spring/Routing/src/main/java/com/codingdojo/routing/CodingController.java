package com.codingdojo.routing;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coding")
public class CodingController {
	
	@RequestMapping("")
	public String Index() {
		return "Hello, Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String Python() {
		return "Python/Django was awesome!";
	}
	
	@RequestMapping("/java")
	public String Java() {
		return "Java/Spring is better";
	}
	
	

}
