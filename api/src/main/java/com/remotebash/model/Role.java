package com.remotebash.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ROLE")
public class Role {
	
	@Id
	UUID id;
	
	@Column(name = "ROLE")
	private String role; 
	
	
}
