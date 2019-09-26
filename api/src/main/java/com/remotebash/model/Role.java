package com.remotebash.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Role.TableName.ROLE)
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name = ColumnName.ID)
	private UUID id;
	
	@Column(name = ColumnName.ROLE)
	private String role; 
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private static class ColumnName {
		static final String ID = "ID";
		static final String ROLE = "ROLE";
	}
	
	public class TableName {
		static final String ROLE = "[ROLE]";
	}
	
}
