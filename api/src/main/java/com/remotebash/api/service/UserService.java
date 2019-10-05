package com.remotebash.api.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.remotebash.api.exception.RegisterUserException;
import com.remotebash.api.model.Role;
import com.remotebash.api.model.User;
import com.remotebash.api.repository.RoleRepository;
import com.remotebash.api.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final RoleRepository roleRepository;
	
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,  RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.roleRepository = roleRepository;
	}

	public void saveUser(User user) throws RegisterUserException {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("USER");
        user.setRoleSet(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
}
