package com.remotebash.controller.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remotebash.model.Computer;
import com.remotebash.model.Laboratory;
import com.remotebash.model.User;

@RestController
@RequestMapping("/register")
public class RegisterRestController {

	@PostMapping("/users")
	public void registerUsers(@RequestBody User user) {
		//TODO CODE
	} 
	
	@PostMapping("/computers")
	public void registerComputers(@RequestBody Computer computer) {
		//TODO CODE
	} 
	
	@PostMapping("/laboratories")
	public void registerLaboratories(@RequestBody Laboratory laboratory) {
		//TODO CODE
	} 
	
}
