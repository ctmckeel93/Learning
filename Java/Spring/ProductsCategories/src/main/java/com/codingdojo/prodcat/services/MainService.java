package com.codingdojo.prodcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.prodcat.models.Category;
import com.codingdojo.prodcat.models.Product;
import com.codingdojo.prodcat.repositories.CategoryRepository;
import com.codingdojo.prodcat.repositories.ProductRepository;

@Service
public class MainService {
	private final ProductRepository products;
	private final CategoryRepository categories;
	
	public MainService(ProductRepository ps, CategoryRepository cs) {
		this.products = ps;
		this.categories = cs;
	}
	
	
	public List<Product> allProducts() {
		return products.findAll();
	}
	public List<Category> allCategories() {
		return categories.findAll();
	}
	
	public Product createProduct(Product prod) {
		return products.save(prod);
	}
	
	public Category createCat(Category cat) {
		return categories.save(cat);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> p = products.findById(id);
		if (p.isPresent()) {
			return p.get();
		}
		else {
			return null;
		}
	}
	
	public Category findCat(Long id) {
		Optional<Category> c = categories.findById(id);
		if (c.isPresent()) {
			return c.get();
		}
		else {
			return null;
		}
	}
	
	public List<Product> findIrrelevantProducts(Category cat) {
		List<Product> p = products.findByCategoriesNotContains(cat);
		return p;
	}
	
	public List<Category> findIrrelevantCategories(Product p) {
		List<Category> c = categories.findByProductsNotContains(p);
		return c;
	}
	
	public void addToList(Category cat, Product prod) {
		prod.getCategories().add(cat);
		products.save(prod);
	}

}
