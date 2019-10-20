package com.remotebash.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remotebash.api.model.Computer;
import com.remotebash.api.repository.ComputerRepository;

@Service
public class ComputerService {
	
	@Autowired
	private ComputerRepository computerRepository;
	
	public Computer getComputerById(Long id) {
		return computerRepository.getOne(id);
	}
	
}
