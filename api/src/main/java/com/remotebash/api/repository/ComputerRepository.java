package com.remotebash.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remotebash.api.model.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long>{
	Computer findByMacaddressIn(List<String> macAddressList);
	Computer findByIdIn(List<Long> computerListId);
}
