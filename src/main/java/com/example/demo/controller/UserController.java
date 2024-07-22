package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UnauthorizedException;
import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.service.TokenService;
import com.example.demo.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;

	@GetMapping("/account")
	public User getUserData(@RequestHeader("Authorization") String token) {
		Token authToken = tokenService.findByToken(token);
		if (authToken != null) {
			return userService.findById(authToken.getUserId()).orElseThrow(() -> new UnauthorizedException());
		} else {
			throw new UnauthorizedException();
		}
	}
	
	   @GetMapping("/users")
	    public List<User> getAllUsers(@RequestHeader("Authorization") String token) {
	    	Token authToken = tokenService.findByToken(token);
	        if (authToken != null) {
	            User user = userService.findById(authToken.getUserId()).orElseThrow(() -> new UnauthorizedException());
	            if ("ADMIN".equals(user.getRuolo())) {
	                return userService.findAll();
	            } else {
	                throw new UnauthorizedException();
	            }
	        } else {
	            throw new UnauthorizedException();
	        }
	    }
}
