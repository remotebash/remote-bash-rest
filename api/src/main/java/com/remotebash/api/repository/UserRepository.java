package com.remotebash.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remotebash.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findUserByEmail(String email);
	User findByIdIn(List<Long> userIdList);
}
