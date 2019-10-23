package com.remotebash.api.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remotebash.api.model.User;
import com.remotebash.api.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginRestController {
	
	private final UserService userService;

	public LoginRestController(UserService userService) {
		super();
		this.userService = userService;
	} 
	
	@GetMapping
	public ResponseEntity<String> login(@RequestBody User user) {
		User userExists = userService.findUserByEmail(user.getEmail()); 
		
		if (userExists != null) {
			return ResponseEntity.ok().body("Usuário logado!"); 
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	

}
