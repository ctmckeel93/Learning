package com.codingdojo.prodcat.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.prodcat.models.Category;
import com.codingdojo.prodcat.models.Product;
import com.codingdojo.prodcat.services.MainService;

@Controller
public class HomeController {
	private final MainService service;
	
	public HomeController(MainService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	@RequestMapping("/products")
	public String products(Model model) {
		List<Product> products = service.allProducts();
		model.addAttribute("products", products);
		return "products.jsp";
	}
	@RequestMapping("/categories")
	public String categories(Model model) {
		List<Category> categories = service.allCategories();
		model.addAttribute("categories", categories);
		return "categories.jsp";
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product p) {
		
		return "forms/product.jsp";
	}
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category c) {
		service.createCat(c);
		return "forms/category.jsp";
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product p, BindingResult result) {
		service.createProduct(p);
		return "redirect:/products";
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category c, BindingResult result) {
		service.createCat(c);
		return "redirect:/categories";
	}
	
	@RequestMapping("/products/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model) {
		Product product = service.findProduct(id);
		List<Category> relevant = product.getCategories();
		List<Category> irrelevant = service.findIrrelevantCategories(product);
		
		model.addAttribute("relevants", relevant);
		model.addAttribute("irrelevants", irrelevant);
		model.addAttribute("product", product);
		return "add/product.jsp";
	}
	
	@RequestMapping("/categories/{id}")
	public String viewCategory(@PathVariable("id") Long id, Model model) {
		Category cat = service.findCat(id);
		List<Product> relevant = cat.getProducts();
		List<Product> irrelevant = service.findIrrelevantProducts(cat);
		
		model.addAttribute("relevants", relevant);
		model.addAttribute("irrelevants", irrelevant);
		model.addAttribute("category", cat);
		return "add/category.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@RequestParam("product") Long productId, @RequestParam("category") Long catId) {
		Product p =  service.findProduct(productId);
		Category c = service.findCat(catId);
		service.addToList(c, p);
		
		return "redirect:/";
	}
}
