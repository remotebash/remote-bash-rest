package com.remotebash.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.remotebash.api.model.Command;
import com.remotebash.api.model.Computer;
import com.remotebash.api.model.Laboratory;
import com.remotebash.api.model.User;

@Service
public class CommandService {

	private final ComputerService computerService;
	private final LaboratoryService laboratoryService;
	private final UserService userService;

	private static final String URL_MICROSERVICE_COMMAND = "http://commandsremotebash.azurewebsites.net/command";

	public CommandService(ComputerService computerService, UserService userService,
			LaboratoryService laboratoryService) {
		this.computerService = computerService;
		this.userService = userService;
		this.laboratoryService = laboratoryService;
	}

	public Command executeOnComputer(Command command) throws Exception {
		if (command == null)
			throw new Exception("command não pode ser null");

		String warning = command.validateCommandToExecute();
		if (warning.trim().length() > 0)
			throw new Exception(warning);

		if (command.getIdComputer() == null) {
			throw new Exception("O IdComputer não pode ser null.");
		}
		else if(command.getIdComputer() <= 0){
			throw new Exception("Informe um IdComputer válido.");
		}
		
		User user = userService.getUserById(command.getUserId());
		if (user == null)
			throw new Exception("Usuário com o id " + command.getUserId() + " não existe.");

		Computer computer = computerService.getComputerById(command.getIdComputer());
		if (computer == null)
			throw new Exception("Computador com o id " + command.getIdComputer() + " não existe.");

		command.setIdCommand(UUID.randomUUID().toString());
		command.setStart(new Date());
		command.setIsExecuted(false);
		command.setEnd(null);
		command.setResult("");
		command.setOperationalSystem(computer.getOperationalSystem());

		if (!computerService.isComputerOnline(command.getIdComputer())) {
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
		Command cmd = new Gson().fromJson(response, Command.class);
		return cmd;
	}

	public String executeOnLaboratory(Command command) throws Exception {
		if (command == null)
			throw new Exception("command não pode ser null");

		String warning = command.validateCommandToExecute();
		if (warning.trim().length() > 0)
			throw new Exception(warning);
		
		if (command.getIdLaboratory() == null) {
			throw new Exception("O IdLaboratory não pode ser null.");
		}
		else if(command.getIdLaboratory() <= 0){
			throw new Exception("Informe um IdLaboratory válido.");
		}
		
		User user = userService.getUserById(command.getUserId());
		if (user == null)
			throw new Exception("Usuário com o id " + command.getUserId() + " não existe.");

		Laboratory laboratory = laboratoryService.getLaboratoryById(command.getIdLaboratory());
		if (laboratory == null)
			throw new Exception("Laboratório com o id " + command.getIdComputer() + " não existe.");
		
		List<Command> commands = new ArrayList<Command>();
		
		for (Computer computer : laboratory.getComputerSet()) {
			command.setIdCommand(UUID.randomUUID().toString());
			command.setStart(new Date());
			command.setIsExecuted(false);
			command.setEnd(null);
			command.setResult("");
			command.setOperationalSystem(computer.getOperationalSystem());
			command.setIdComputer(computer.getId());
			commands.add(command);
		}
		Gson gson = new Gson();
		String json = gson.toJson(commands);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> medias = new ArrayList<MediaType>();
		medias.add(MediaType.APPLICATION_JSON);
		medias.add(MediaType.APPLICATION_JSON_UTF8);
		headers.setAccept(medias);
		HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
		String response = restTemplate.postForObject(URL_MICROSERVICE_COMMAND + "/laboratory", requestEntity,
				String.class);
		System.err.println(response);
		return response;
	}

	public List<Command> getCommandsByComputer(long idComputer) throws JsonParseException, JsonMappingException, IOException {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(URL_MICROSERVICE_COMMAND).path("/computer/commands/" + idComputer);
		Invocation.Builder invocationBuilder = webTarget.request("application/json;charset=UTF-8");
		Response response = invocationBuilder.get();
		String json = response.readEntity(String.class);
		Gson gson = new Gson();
		List<Command> commands = Arrays.asList(gson.fromJson(json, Command[].class));
		return commands;
	}

}
