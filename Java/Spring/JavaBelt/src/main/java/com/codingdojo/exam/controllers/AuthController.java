package com.codingdojo.exam.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.exam.models.StorePackage;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.services.AuthService;
import com.codingdojo.exam.services.PackageService;
import com.codingdojo.exam.validators.UserValidator;

@Controller
public class AuthController {
	
	private AuthService userService;
	private UserValidator userValidator;
	private PackageService packageService;
    
	 public AuthController(AuthService userService, UserValidator userValidator, PackageService packageService) {
	        this.userService = userService;
	        this.packageService = packageService;
	        this.userValidator = userValidator;
	    }
	
	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "/auth/register.jsp";
	}
	
	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        userValidator.validate(user, result);
        StorePackage p = packageService.findPackageByName("Basic");
        user.setUserPackage(p);
        System.out.println(user);
        if (result.hasErrors()) {
            return "/auth/register.jsp";
        }
        
        if(userService.isAdmin() == false) {        	
        	userService.saveUserWithAdminRole(user);
        }
        else {
        	userService.saveWithUserRole(user);
        }
        return "redirect:/login";
    }
     
    // NEW 
    @RequestMapping("/admin")
    public String adminPage(@ModelAttribute("package") StorePackage p, Principal principal, Model model) {
    	System.out.println("Made it!");
        String email = principal.getName();
        List<User> customers = userService.allUsers();
        List<StorePackage> packages = packageService.allPackages();
        model.addAttribute("currentUser", userService.findUserByEmail(email));
        model.addAttribute("customers", customers);
        model.addAttribute("packages", packages);
        return "admin.jsp";
    }
	
	@GetMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "/auth/login.jsp";
    }
	
	@RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model, @ModelAttribute("user") User user, BindingResult result) {
        // 1
        String email = principal.getName();
        List<StorePackage> packages = packageService.allPackages();
        List<User> customers = userService.allUsers();
        user = userService.findUserByEmail(email);
        model.addAttribute("logged_in", user);
        model.addAttribute("packages", packages);
        model.addAttribute("customers", customers);
        return "home.jsp";
    }
	
}
