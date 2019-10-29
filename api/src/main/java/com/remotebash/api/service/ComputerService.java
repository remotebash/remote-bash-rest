package com.remotebash.api.service;

import org.springframework.stereotype.Service;

import com.remotebash.api.exception.RegisterException;
import com.remotebash.api.model.Computer;
import com.remotebash.api.repository.ComputerRepository;

@Service
public class ComputerService {

	private final ComputerRepository computerRepository;

	public ComputerService(ComputerRepository computerRepository) {
		super();
		this.computerRepository = computerRepository;
	} 
	
	
	public void saveComputer(Computer computer) throws RegisterException{
		computerRepository.save(computer);
	}
	
	
}
