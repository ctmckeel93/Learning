package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository repo;
	
	public DojoService(DojoRepository repo) {
		this.repo = repo;
	}
	
	public List<Dojo> allDojos() {
		return repo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return repo.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> dojo = repo.findById(id);
		if (dojo.isPresent()) {
			return dojo.get();
		}
		else {
			return null;
		}
	}
}
