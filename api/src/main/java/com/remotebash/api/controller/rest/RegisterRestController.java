package com.remotebash.api.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remotebash.api.exception.RegisterUserException;
import com.remotebash.api.model.Command;
import com.remotebash.api.model.Computer;
import com.remotebash.api.model.Laboratory;
import com.remotebash.api.model.User;
import com.remotebash.api.service.CommandService;
import com.remotebash.api.service.UserService;

@RestController
@RequestMapping("/register")
public class RegisterRestController {

	@Autowired
	private CommandService commandService;
	private final UserService userService; 
	
	public RegisterRestController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/users")
	public ResponseEntity<String> registerUsers(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return ResponseEntity.ok("Usuário cadastrado com sucesso");
		} catch (RegisterUserException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	} 
	
	@PostMapping("/computers")
	public void registerComputers(@RequestBody Computer computer) {
		//TODO CODE
	} 
	
	@PostMapping("/laboratories")
	public void registerLaboratories(@RequestBody Laboratory laboratory) {
		//TODO CODE
	} 
	
	@PostMapping("/command")
	public ResponseEntity<Command> registerExecutionCommand(@RequestBody Command command) {
		try {
			Command commandExecuted = commandService.executeCommand(command);
			return ResponseEntity.ok(commandExecuted);
		} catch (Exception e) {
			Command cmd = new Command();
			cmd.setResult(e.getMessage());
			return ResponseEntity.badRequest().body(cmd);
		}
	} 
	
}
