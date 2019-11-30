package com.remotebash.api.service;

import java.util.List;

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
	
	public Laboratory getLaboratoryById(Long id) {
		return laboratoryRepository.getOne(id);
	}
	
	public Laboratory findLaboratoriesById(List<Long> laboratoryIdList) {
		return laboratoryRepository.findByIdIn(laboratoryIdList);
	}
	
	public List<Laboratory> findLaboratories() {
		return laboratoryRepository.findAll();
	}
	
	public void deleteLaboratory(Long id) {
		laboratoryRepository.deleteById(id);
	}
}
