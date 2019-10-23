package com.remotebash.api.controller.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.remotebash.api.model.Computer;
import com.remotebash.api.model.Laboratory;
import com.remotebash.api.model.User;

@RestController
@RequestMapping("/update")
public class UpdateRestController {

	@PutMapping("/users") 
	public void updateUsers(@RequestBody User user) {
		//TODO CODE
	}
	
	@PutMapping("/computers")
	public void updateComputers(@RequestBody Computer computer) {
		//TODO CODE
	}
	
	@PutMapping("/laboratories")
	public void updateLaboratories(@RequestBody Laboratory laboratory) {
		//TODO CODE
	}
	
	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable Long id) {
		//TODO CODE
	}
	
	@PutMapping("/computers/{id}")
	public void updateComputer(@PathVariable Long id) {
		//TODO CODE
	}
	
	@PutMapping("/laboratory/{id}")
	public void updateLaboratory(@PathVariable Long id) {
		//TODO CODE
	}
}
