package com.remotebash.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remotebash.api.model.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, UUID>{
}
