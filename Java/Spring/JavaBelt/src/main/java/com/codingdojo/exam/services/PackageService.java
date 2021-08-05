package com.codingdojo.exam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.exam.models.StorePackage;
import com.codingdojo.exam.repositories.PackageRepository;
import com.codingdojo.exam.repositories.UserRepository;

@Service
public class PackageService {
	
	private final PackageRepository packages;
	private final UserRepository users;
	
	public PackageService(PackageRepository repo, UserRepository users) {
		this.packages = repo;
		this.users = users;
	}
	
	public List<StorePackage> allPackages() {
		return packages.findAll();
	}
	
	public StorePackage findPackage(Long id) {
		return packages.findById(id).orElse(null);
	}
	
	public StorePackage findPackageByName(String name) {
		return packages.findByName(name);
	}
	
	public StorePackage createPackage(StorePackage p) {
		return packages.save(p);
	}
	
	public StorePackage updatePackage(StorePackage p) {
		return packages.save(p);
	}
	
	public void deletePackage(Long id) {
		packages.deleteById(id);
	}
	
//	List<StorePackage> findOrderedByUserCount;
	
	
}
