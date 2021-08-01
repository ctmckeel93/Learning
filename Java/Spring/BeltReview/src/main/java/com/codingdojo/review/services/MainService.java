package com.codingdojo.review.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.review.models.Event;
import com.codingdojo.review.models.Message;
import com.codingdojo.review.models.User;
import com.codingdojo.review.repositiories.EventRepository;
import com.codingdojo.review.repositiories.MessageRepository;
import com.codingdojo.review.repositiories.UserRepository;

@Service
public class MainService {
	private final MessageRepository mRepo;
	private final EventRepository eRepo;
	private final UserRepository uRepo;
	
	public MainService(MessageRepository m, EventRepository e, UserRepository u) {
		this.mRepo = m;
		this.eRepo = e;
		this.uRepo = u;
		
	}
	
	public List<Event> findByState(String state) {
		return eRepo.findAllByState(state);
	}
	
	public List<Event> findAllNotInState(String state) {
		return eRepo.findAllByStateNot(state);
	}
	
	public Event findEvent(Long id) {
		return eRepo.findById(id).orElse(null);
	}
	
	public Event createEvent(Event e) {
		return eRepo.save(e);
	}
	
	public Message createMessage(Message m) {
		return mRepo.save(m);
	}
	
	public void addToUserEvents(User user, Event e) {
		user.getEvents().add(e);
		eRepo.save(e);
	}
	
	public void removeUserFromEvent(User user, Event e) {
		user.getEvents().remove(e);
		eRepo.save(e);
	}
	
	public User findUserById(Long id) {
		return uRepo.findById(id).orElse(null);
	}
	
	public Event updateEvent(Event e) {
		
		return eRepo.save(e);
	}
	
	public void deleteEventById(Long id) {
		eRepo.deleteById(id);
	}
}
