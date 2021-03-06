package com.remotebash.api.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.remotebash.api.exception.RegisterException;
import com.remotebash.api.model.Role;
import com.remotebash.api.model.User;
import com.remotebash.api.repository.RoleRepository;
import com.remotebash.api.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final RoleRepository roleRepository;

	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;		
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	public void saveUser(User user) throws RegisterException {
		Role userRole = roleRepository.findByRole("USER");
		user.setRoleSet(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
		
	}

	public void validateIfUserEmailAlreadyExists(String email) throws RegisterException {

		User userEmail = userRepository.findUserByEmail(email);

		if (userEmail != null) {
			throw new RegisterException("Email já existente");
		}
	}

	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}
	
	public User findUserByIdIn(List<Long> userIdList) {
		return userRepository.findByIdIn(userIdList);
	}
	
	public List<User> findUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
