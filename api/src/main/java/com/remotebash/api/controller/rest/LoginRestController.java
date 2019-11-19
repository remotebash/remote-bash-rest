package com.remotebash.api.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remotebash.api.model.User;
import com.remotebash.api.service.UserService;

@RestController
@RequestMapping("/user")
public class LoginRestController {
	
	private final UserService userService;

	public LoginRestController(UserService userService) {
		super();
		this.userService = userService;
	} 
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		User userExists = userService.findUserByEmail(user.getEmail());
		return userExists != null ? ResponseEntity.ok().body(userExists) : ResponseEntity.badRequest().build();
	}	

}
