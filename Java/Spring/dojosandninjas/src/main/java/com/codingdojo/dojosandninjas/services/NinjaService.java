package com.codingdojo.dojosandninjas.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository repo;
	
	public NinjaService(NinjaRepository repo) {
		this.repo = repo;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return repo.save(ninja);
	}
}
