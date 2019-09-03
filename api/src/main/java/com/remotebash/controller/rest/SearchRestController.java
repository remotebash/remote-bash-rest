package com.remotebash.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchRestController {
	
	@GetMapping("/users")
	public void searchUsers() {
		//TODO CODE
	}
	
	@GetMapping("/computers")
	public void searchComputers() {
		//TODO CODE 
	}
	
	@GetMapping("/laboratories")
	public void searchLaboratories() {
		//TODO CODE
	}
	
	@GetMapping("/users/{id}")
	public void searchUserById(@PathVariable Long id) {
		//TODO CODE
	}
	
	@GetMapping("/computers/{id}") 
	public void searchComputerById(@PathVariable Long id) {
		//TODO CODE 
	}
	
	@GetMapping("/laboratories/{id}")
	public void searchLaboratoryById(@PathVariable Long id) {
		
	}

}
