package com.remotebash.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Role.TableName.ROLE)
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnName.ROLE_ID)
	private Long id;
	
	@Column(name = ColumnName.ROLE)
	private String role;  

	public Role() {}
	
	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private static class ColumnName {
		static final String ROLE_ID = "ROLE_ID";
		static final String ROLE = "ROLE";
	}
	
	public class TableName {
		static final String ROLE = "[ROLE]";
	}
	
}
