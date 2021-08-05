package com.codingdojo.exam.services;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.exam.models.Role;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.repositories.RoleRepository;
import com.codingdojo.exam.repositories.UserRepository;
 
@Service
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public AuthService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    // 1
    public User saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        return userRepository.save(user);
    }
     
     // 2 
    public User saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        return userRepository.save(user);
    }    
    
    public boolean isAdmin() {
    	List<Role> admin = roleRepository.findByName("ROLE_ADMIN");
    	for (int i = 0; i < admin.size(); i++) {
    		if (admin.get(i).getUsers().isEmpty()) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public User findUserByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
    
    public User findUserById(Long id) {
    	return userRepository.findById(id).orElse(null);
    }
    
    public List<User> allUsers() {
    	return userRepository.findAll();
    }
    
    public List<User> findUserByRoles(String role){
    	List<User> result = userRepository.findUserByRoles("ROLE_USER");
    	return result;
    }
    
    public User updateUser(User user) {
    	return userRepository.save(user);
    }
}

