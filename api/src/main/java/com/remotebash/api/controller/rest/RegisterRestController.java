package com.remotebash.api.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remotebash.api.exception.RegisterException;
import com.remotebash.api.model.Computer;
import com.remotebash.api.model.Command;
import com.remotebash.api.model.Laboratory;
import com.remotebash.api.model.User;
import com.remotebash.api.service.ComputerService;
import com.remotebash.api.service.LaboratoryService;
import com.remotebash.api.service.CommandService;
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
	private final CommandService commandService;

	public RegisterRestController(UserService userService, ComputerService computerService,
			LaboratoryService laboratoryService, CommandService commandService) {
		super();
		this.userService = userService;
		this.computerService = computerService;
		this.laboratoryService = laboratoryService;
		this.commandService = commandService;
	}

	@ApiOperation(value = "Cadastrar usuários", notes = "Cadastrar usuário")
	@ApiResponses({ @ApiResponse(code = 200, message = "Usuário cadastrado com sucesso") })
	@PostMapping("/users")
	public ResponseEntity<String> registerUsers(@RequestBody User user) {
		try {
			userService.validateIfUserEmailAlreadyExists(user.getEmail());
			userService.saveUser(user);
			return ResponseEntity.ok().body("Usuário cadastrado com sucesso!");
		} catch (RegisterException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@ApiOperation(value = "Cadastrar computadores", notes = "Cadastrar computador")
	@ApiResponses({ @ApiResponse(code = 200, message = "Computador cadastrado com sucesso") })
	@PostMapping("/computers")
	public ResponseEntity<Computer> registerComputers(@RequestBody Computer computer) {
		try {
			computerService.saveComputer(computer);
			return ResponseEntity.ok().body(computer);
		} catch (RegisterException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@ApiOperation(value = "Cadastrar laboratórios", notes = "Cadastrar laboratório")
	@ApiResponses({ @ApiResponse(code = 200, message = "Laboratório cadastrado com sucesso") })
	@PostMapping("/laboratories")
	public ResponseEntity<Laboratory> registerLaboratories(@RequestBody Laboratory laboratory) {
		try {
			laboratoryService.saveLaboratory(laboratory);
			return ResponseEntity.ok().body(laboratory);
		} catch (RegisterException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@ApiOperation(value = "Cadastro de execução de comandos", notes = "Cadastro de execução de comandos")
	@ApiResponses({ @ApiResponse(code = 200, message = "Objeto do tipo Command") })
	@PostMapping("/command")
	public ResponseEntity<Command> registerExecutionCommand(@RequestBody Command command) {
		try {
			Command commandExecuted = commandService.executeOnComputer(command);
			return ResponseEntity.ok(commandExecuted);
		} catch (Exception e) {
			if (command != null) {
				command.setResult(e.getMessage());
				return ResponseEntity.badRequest().body(command);
			} else {
				Command cmd = new Command();
				cmd.setResult(e.getMessage());
				return ResponseEntity.badRequest().body(cmd);
			}
		}
	}
	
	@ApiOperation(value = "Cadastro de execução de comandos no laboratório", notes = "Cadastro de execução de comandos")
	@ApiResponses({ @ApiResponse(code = 200, message = "Objeto do tipo String") })
	@PostMapping("/command/laboratory")
	public ResponseEntity<String> registerExecutionCommandOnLaboratory(@RequestBody Command command) {
		try {
			String commandExecuted = commandService.executeOnLaboratory(command);
			return ResponseEntity.ok(commandExecuted);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
