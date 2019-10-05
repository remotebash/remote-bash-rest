package com.remotebash.api.controller.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remotebash.api.model.Computer;
import com.remotebash.api.model.Laboratory;
import com.remotebash.api.model.User;

@RestController
@RequestMapping("/delete")
public class DeteleRestController {

	@DeleteMapping("/users") 
	public void deleteUsers(@RequestBody User user ) {
		//TODO CODE
	}
	
	@DeleteMapping("/computers")
	public void deleteComputers(@RequestBody Computer computer) {
		//TODO CODE
	}
	
	@DeleteMapping("/laboratories")
	public void deleteLaboratories(@RequestBody Laboratory laboratory) {
		//TODO CODE
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		//TODO CODE
	}
	
	@DeleteMapping("/computers/{id}")
	public void deleteComputer(@PathVariable Long id) {
		//TODO CODE
	}
	
	@DeleteMapping("/laboratory/{id}")
	public void deleteLaboratory(@PathVariable Long id) {
		//TODO CODE
	}
	
	
}
