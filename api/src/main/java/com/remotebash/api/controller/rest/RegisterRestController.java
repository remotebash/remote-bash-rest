package com.remotebash.api.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remotebash.api.exception.RegisterException;
import com.remotebash.api.model.Computer;
import com.remotebash.api.model.Laboratory;
import com.remotebash.api.model.User;
import com.remotebash.api.service.ComputerService;
import com.remotebash.api.service.LaboratoryService;
import com.remotebash.api.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterRestController {

	private final UserService userService;
	private final ComputerService computerService;
	private final LaboratoryService laboratoryService;
	
	public RegisterRestController(UserService userService, ComputerService computerService,
			LaboratoryService laboratoryService) {
		super();
		this.userService = userService;
		this.computerService = computerService;
		this.laboratoryService = laboratoryService;
	}

	@ApiOperation(value = "Cadastrar usuários", notes = "Cadastrar usuário")
	@ApiResponses({ @ApiResponse(code = 200, message = "Usuário cadastrado com sucesso") })
	@PostMapping("/users")
	public ResponseEntity<String> registerUsers(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return ResponseEntity.ok().body("Usuário cadastrado com sucesso!");
		} catch (RegisterException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@ApiOperation(value = "Cadastrar computadores", notes = "Cadastrar computador")
	@ApiResponses({ @ApiResponse(code = 200, message = "Computador cadastrado com sucesso") })
	@PostMapping("/computers")
	public ResponseEntity<String> registerComputers(@RequestBody Computer computer) {
		try {
			computerService.saveComputer(computer);
			return ResponseEntity.ok().body("Computador cadastrado com sucesso!");
		} catch (RegisterException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@ApiOperation(value = "Cadastrar laboratórios", notes = "Cadastrar laboratório")
	@ApiResponses({ @ApiResponse(code = 200, message = "Laboratório cadastrado com sucesso") })
	@PostMapping("/laboratories")
	public ResponseEntity<String> registerLaboratories(@RequestBody Laboratory laboratory) {
		try {
			laboratoryService.saveLaboratory(laboratory);
			return ResponseEntity.ok().body("Laboratório cadastrado com sucesso!");
		} catch (RegisterException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
