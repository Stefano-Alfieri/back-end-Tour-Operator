package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	 @Autowired
	 private  UserRepository userRepository;
	 
	    public User findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

	    public List<User> findAll() {
	        return userRepository.findAll();
	    }

		public Optional<User> findById(Long userId) {
			 return userRepository.findById(userId);
		}
}
