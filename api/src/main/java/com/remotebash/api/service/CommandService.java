package com.remotebash.api.service;

import java.util.Date;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.remotebash.api.model.Command;
import com.remotebash.api.model.Computer;
import com.remotebash.api.model.User;

@Service
public class CommandService {
	
	private final ComputerService computerService;
	private final UserService userService;
	
	private static final String URL_MICROSERVICE_COMMAND = "http://commandsremotebash.azurewebsites.net/command";
	
	public CommandService(ComputerService computerService, UserService userService) { 
		this.computerService = computerService;
		this.userService = userService;
	}
	
	public Command executeCommand(Command command) throws Exception {		
		if(command == null) throw new Exception("command não pode ser null");		
		
		String warning = command.validateCommandToExecute();
		if(warning.trim().length() > 0)
			throw new Exception(warning);
		
		User user = userService.getUserById(command.getUserId());
		if(user == null)
			throw new Exception("Usuário com o id " + command.getUserId() + " não existe.");
		
		Computer computer = computerService.getComputerById(command.getIdComputer());
		if(computer == null)
			throw new Exception("Computador com o id " + command.getIdComputer() + " não existe.");
		
		if(!computerService.isComputerOnline(command.getIdComputer())) {
			throw new Exception("O computador não está online.\n");
		}
		
		command.setIdCommand(UUID.randomUUID().toString());
		command.setStart(new Date());
		command.setExecuted(false);
		command.setEnd(null);
		command.setResult("");
		command.setOperationalSystem(computer.getOperationalSystem());
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
	    HttpEntity<Command> requestEntity = new HttpEntity<>(command, headers);
	    Command response = restTemplate.postForObject(URL_MICROSERVICE_COMMAND, requestEntity, Command.class);	    
		
	    return response;
	}	
}
