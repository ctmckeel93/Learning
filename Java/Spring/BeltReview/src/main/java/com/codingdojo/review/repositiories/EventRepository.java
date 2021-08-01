package com.codingdojo.review.repositiories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.review.models.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

	public List<Event> findAll();
	
	public List<Event> findAllByState(String state);
	
	public List<Event> findAllByStateNot(String state);
	
}
