package com.remotebash.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remotebash.api.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
