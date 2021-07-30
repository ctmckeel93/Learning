package com.codingdojo.prodcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.prodcat.models.Category;
import com.codingdojo.prodcat.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	
	// Retrieves a list of all categories for a particular product
    List<Product> findAllByCategories(Category cat);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category cat);

}
