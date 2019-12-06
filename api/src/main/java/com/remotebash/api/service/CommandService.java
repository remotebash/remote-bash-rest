package com.remotebash.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
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
		
		command.setIdCommand(UUID.randomUUID().toString());
		command.setStart(new Date());
		command.setIsExecuted(false);
		command.setEnd(null);
		command.setResult("");
		command.setOperationalSystem(computer.getOperationalSystem());
		
		if(!computerService.isComputerOnline(command.getIdComputer())) {
			command.setIsExecuted(true);
			command.setEnd(new Date());
			command.setResult("O comando não foi executado pois o computador não está online.\n");
			return command;
		}
		
		String json = new JSONObject(command).toString();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> medias = new ArrayList<MediaType>();
		medias.add(MediaType.APPLICATION_JSON);
		medias.add(MediaType.APPLICATION_JSON_UTF8);
		headers.setAccept(medias);
	    HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
	    String response = restTemplate.postForObject(URL_MICROSERVICE_COMMAND, requestEntity, String.class);	    
	    Command cmd = new ObjectMapper().readValue(response, Command.class);
	    return cmd;
	}	
}
