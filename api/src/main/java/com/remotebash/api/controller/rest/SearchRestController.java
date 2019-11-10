package com.remotebash.api.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.remotebash.api.model.Computer;
import com.remotebash.api.model.Laboratory;
import com.remotebash.api.model.User;
import com.remotebash.api.service.ComputerService;
import com.remotebash.api.service.LaboratoryService;
import com.remotebash.api.service.UserService;

@RestController
@RequestMapping("/search")
public class SearchRestController {

	private final UserService userService;
	private final ComputerService computerService; 
	private final LaboratoryService laboratoryService;
	
	public SearchRestController(ComputerService computerService, LaboratoryService laboratoryService, UserService userService) {
		super();
		this.computerService = computerService;
		this.laboratoryService = laboratoryService;
		this.userService = userService;
	}

	@GetMapping("/users")
	public User searchUsers(@RequestParam("userList") List<Long> userIdList) {
		return userService.findUserByIdIn(userIdList);
	}
	
	@GetMapping("/laboratories")
	public Laboratory searchLaboratories(@RequestParam("laboratoryIdList") List<Long> laboratoryIdList) {
		return laboratoryService.findLaboratoriesById(laboratoryIdList);
	}
	
	@GetMapping("/users/{id}")
	public User searchUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/computers/{id}") 
	public Computer searchComputerById(@PathVariable Long id) {
		return computerService.getComputerById(id);
	}
	
	@GetMapping("/laboratories/{id}")
	public Laboratory searchLaboratoryById(@PathVariable Long id) {
		return laboratoryService.getLaboratoryById(id);
	}
	
	@GetMapping("/computers")
	public Computer searchComputersByMacAddress(@RequestParam List<String> macAddressList) {
		return computerService.searchComputersByMacAddress(macAddressList);
	}

}
