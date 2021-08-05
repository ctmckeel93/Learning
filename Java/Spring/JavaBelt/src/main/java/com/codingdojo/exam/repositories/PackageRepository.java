package com.codingdojo.exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.exam.models.StorePackage;

@Repository
public interface PackageRepository extends CrudRepository<StorePackage, Long> {
	List<StorePackage> findAll();
	StorePackage findByName(String name);
	
//	@Query("SELECT * FROM 'packages' ORDER BY ")
//	List<StorePackage> findByOrderByCustomersSize();
}
