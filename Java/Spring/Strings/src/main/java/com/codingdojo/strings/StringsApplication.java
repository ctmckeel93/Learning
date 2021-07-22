package com.codingdojo.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	@RequestMapping("/")
	public String Home() {
		return "Welcome client, I hope you're having a wonderful day!";
	}
	
	@RequestMapping("/random")
	public String Random() {
		return "Spring boot is easy to use, no wonder its number one- wait...wrong company...";
	}

}
