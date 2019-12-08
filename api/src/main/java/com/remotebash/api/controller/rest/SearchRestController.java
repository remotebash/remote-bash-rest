package com.remotebash.api.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.remotebash.api.model.Command;
import com.remotebash.api.model.Computer;
import com.remotebash.api.model.Laboratory;
import com.remotebash.api.model.User;
import com.remotebash.api.service.CommandService;
import com.remotebash.api.service.ComputerService;
import com.remotebash.api.service.LaboratoryService;
import com.remotebash.api.service.UserService;

@RestController
@RequestMapping("/search")
public class SearchRestController {

	private final UserService userService;
	private final ComputerService computerService; 
	private final LaboratoryService laboratoryService;
	private final CommandService commandService;
	
	public SearchRestController(ComputerService computerService, LaboratoryService laboratoryService, UserService userService, CommandService commandService) {
		super();
		this.computerService = computerService;
		this.laboratoryService = laboratoryService;
		this.userService = userService;
		this.commandService = commandService;
	}

	@GetMapping("/users")
	public List<User> searchUsers() {
		return userService.findUsers();
	}
	
	@GetMapping("/laboratories")
	public List<Laboratory> searchLaboratories() {
		return laboratoryService.findLaboratories();
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
	
	@GetMapping("/command/{idComputer}")
	public List<Command> searchCommandsByComputer(@RequestParam long idComputer) throws Exception {
		return commandService.getCommandsByComputer(idComputer);
	}

}
