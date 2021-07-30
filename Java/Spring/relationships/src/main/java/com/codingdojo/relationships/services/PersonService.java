package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository repo;
	
	public PersonService(PersonRepository repo) {
		this.repo = repo;
	}
	
	public List<Person> allPersons() {
		return repo.findAll();
	}
	
	public Person createPerson(Person person) {
		return repo.save(person);
	}
	
	public Person findPerson(Long id) {
		Optional<Person> p =  repo.findById(id);
		if (p.isPresent()) {
			return p.get();
		}
		else {
			return null;
		}
	}
}
