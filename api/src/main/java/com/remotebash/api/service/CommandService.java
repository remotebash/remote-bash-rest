package com.remotebash.api.service;

import java.util.Date;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remotebash.api.model.Command;
import com.remotebash.api.model.Computer;
import com.remotebash.api.model.User;

@Service
public class CommandService {
	
	@Autowired
	private ComputerService computerService;
	@Autowired
	private UserService userService;
	
	private static final String URL_MICROSERVICE_COMMAND = "http://commandsremotebash.azurewebsites.net/";
	
	public Command executeCommand(Command command) throws Exception {
		String warning = validateCommandToExecute(command);
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
		command.setExecuted(false);
		command.setEnd(null);
		command.setPlatform(computer.getPlatform());
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(URL_MICROSERVICE_COMMAND).path("/command");
		Invocation.Builder invocationBuilder =  webTarget.request("application/json;charset=UTF-8"); 
		Response response = invocationBuilder.post(Entity.entity(command, "application/json;charset=UTF-8"));
		
		return response.readEntity(Command.class);
	}
	
	private String validateCommandToExecute(Command command) {		
		String warning = "";
		if(command != null) {
			//TODO VERIFICAR SE O PC TA ONLINE
			if(command.getUserId() == null) {
				warning += "Objeto 'Command' não pode ser null. ";
			}
			if(command.getCommand() == null) {
				warning += "O Comando não pode ser null. ";
			}
			if(command.getCommand().trim().length() == 0) {
				warning += "O Comando não pode ser vazio. ";
			}
			if(command.getIdComputer() == null) {
				warning += "O IdComputer não pode ser vazio. ";
			}
			
		}else {		
			warning = "Objeto 'Command' não pode ser null";
		}
		return warning;
	}
}
