package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UnauthorizedException;
import com.example.demo.model.User;
import com.example.demo.request.AuthRequest;
import com.example.demo.response.AuthResponse;
import com.example.demo.service.TokenService;
import com.example.demo.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;
    
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
    	User user = userService.findByEmail(authRequest.getEmail());
    	if (user != null && user.getPassword().equals(authRequest.getPassword())) {
    		String token = tokenService.createToken(user.getId()).getToken();
            return new AuthResponse(token);
        } else {
            throw new UnauthorizedException();
        }
    }
    
    @PostMapping("/logout")
    public void logout(@RequestHeader("Authorization") String token) {
    	tokenService.deleteByToken(token);
    }

}
