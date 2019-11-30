package com.remotebash.api.service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.remotebash.api.exception.RegisterException;
import com.remotebash.api.model.Computer;
import com.remotebash.api.repository.ComputerRepository;

@Service
public class ComputerService {
	private final ComputerRepository computerRepository;
	private final static String URL_MICROSERVICE_ONLINE = "https://remotebash.herokuapp.com/";

	public ComputerService(ComputerRepository computerRepository) {
		super();
		this.computerRepository = computerRepository;
	}

	public void saveComputer(Computer computer) throws RegisterException {
		computerRepository.save(computer);
	}

	public Computer getComputerById(Long id) {
		return computerRepository.getOne(id);
	}

	public boolean isComputerOnline(Long idComputer) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(URL_MICROSERVICE_ONLINE).path("/status/" + idComputer);
		Invocation.Builder invocationBuilder = webTarget.request("application/json;charset=UTF-8");
		Response response = invocationBuilder.get();
		JSONObject data = new JSONObject(response.readEntity(String.class));
		return data.getString("status").toLowerCase().equals("online");
	}
	
	public Computer searchComputersByMacAddress(List<String> macAddressList) {
		return computerRepository.findByMacaddressIn(macAddressList);
	}
	
	public Computer searchComputersByIdIn(List<Long> computerListId) {
		return computerRepository.findByIdIn(computerListId);
	}
	
	public void deleteComputer(Long id) {
		computerRepository.deleteById(id);
	}
	
}