package com.remotebash.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remotebash.model.Laboratory;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, UUID> {
}
