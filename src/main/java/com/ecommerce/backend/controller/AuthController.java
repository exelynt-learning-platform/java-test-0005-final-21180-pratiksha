package com.ecommerce.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.entity.User;
import com.ecommerce.backend.security.JwtUtil;
import com.ecommerce.backend.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}
	@PostMapping("/login")
	public String login(@RequestBody User user) {

	    // For now simple validation (later we improve)
	    if(user.getEmail() != null) {
	        JwtUtil jwtUtil = new JwtUtil();
	        return jwtUtil.generateToken(user.getEmail());
	    }

	    throw new RuntimeException("Invalid login");
	}
}
