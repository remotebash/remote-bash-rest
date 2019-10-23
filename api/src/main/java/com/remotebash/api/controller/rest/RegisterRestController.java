package com.remotebash.api.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remotebash.api.exception.RegisterUserException;
import com.remotebash.api.model.Computer;
import com.remotebash.api.model.Laboratory;
import com.remotebash.api.model.User;
import com.remotebash.api.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/register")
public class RegisterRestController {

	private final UserService userService; 
	
	public RegisterRestController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ApiOperation(value = "Cadastrar usuários", notes = "Cadastrar usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário cadastrado com sucesso")
    })
	
	@CrossOrigin
	@PostMapping("/users")
	public ResponseEntity<String> registerUsers(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return ResponseEntity.ok().body("Usuário cadastrado com sucesso!");
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
	
}
