package com.remotebash.api.service;

import org.springframework.stereotype.Service;

import com.remotebash.api.exception.RegisterException;
import com.remotebash.api.model.Laboratory;
import com.remotebash.api.repository.LaboratoryRepository;

@Service
public class LaboratoryService {
	
	private final LaboratoryRepository laboratoryRepository;

	public LaboratoryService(LaboratoryRepository laboratoryRepository) {
		super();
		this.laboratoryRepository = laboratoryRepository;
	}
	
	public void saveLaboratory(Laboratory laboratory) throws RegisterException {
		laboratoryRepository.save(laboratory);
	}
	

}
