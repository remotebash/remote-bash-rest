package com.remotebash.api.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.remotebash.api.model.Computer;
import com.remotebash.api.repository.ComputerRepository;

@Service
public class ComputerService {
	
	private final ComputerRepository computerRepository;
	private final static String URL_MICROSERVICE_ONLINE = "https://remotebash.herokuapp.com/";
	
	public ComputerService(ComputerRepository computerRepository) {
		this.computerRepository = computerRepository;
	}	
	
	public Computer getComputerById(Long id) {
		return computerRepository.getOne(id);
	}
	
	public boolean isComputerOnline(Long idComputer) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(URL_MICROSERVICE_ONLINE).path("/status/123");
		Invocation.Builder invocationBuilder =  webTarget.request("application/json;charset=UTF-8"); 
		Response response = invocationBuilder.get();
		JSONObject data = new JSONObject(response.readEntity(String.class));
		return data.getString("status").toLowerCase().equals("online");
	}
}