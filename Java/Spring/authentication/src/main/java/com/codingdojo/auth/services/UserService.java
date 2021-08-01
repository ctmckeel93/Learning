package com.codingdojo.auth.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.auth.models.User;
import com.codingdojo.auth.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository users;
	
	public UserService(UserRepository repo) {
		this.users = repo;
	}
	
	public User register(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return users.save(user);
	}
	
	// find user by email
    public User findByEmail(String email) {
        return users.findByEmail(email);
    }
    
    public User findUserById(Long id) {
    	Optional<User> user = users.findById(id);
    	if (user.isPresent()) {
    		return user.get();
    	}
    	else {
    		return null;
    	}
    }
    
    public boolean authenticate(String email, String password) {
    	User user = users.findByEmail(email);
    	
    	if (user == null) {
    		return false;
    	}
    	else {
    		if (BCrypt.checkpw(password, user.getPassword())) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
}
