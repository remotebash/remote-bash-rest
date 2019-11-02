package com.remotebash.api.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.remotebash.api.configuration.WebMvcConfig;
import com.remotebash.api.exception.RegisterException;
import com.remotebash.api.model.Role;
import com.remotebash.api.model.User;
import com.remotebash.api.repository.RoleRepository;
import com.remotebash.api.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final WebMvcConfig webMvcConfig;
	private final RoleRepository roleRepository;
	
	public UserService(UserRepository userRepository, WebMvcConfig webMvcConfig,  RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.webMvcConfig = webMvcConfig;
		this.roleRepository = roleRepository;
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email); 
	}

	public void saveUser(User user) throws RegisterException {
	
		this.validateIfUserEmailAlreadyExists(user.getEmail());
		
		user.setPassword(webMvcConfig.passwordEncoder().encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("USER");
        user.setRoleSet(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	

	public void validateIfUserEmailAlreadyExists(String email) throws RegisterException {
		
		User userEmail = userRepository.findUserByEmail(email);
		
		if (userEmail != null) {
			throw new RegisterException("Email já existente");
		}

  public User getUserById(Long id) {
		return userRepository.getOne(id);
	}
}
