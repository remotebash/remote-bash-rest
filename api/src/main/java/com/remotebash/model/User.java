package com.remotebash.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = User.TableName.USER)
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = ColumnName.ID)
	private UUID id;
	
	@Column(name = ColumnName.NAME)
	private String name;
	
	@Column(name = ColumnName.PASSWORD)
	private String password;
	
	@Column(name = ColumnName.CELLPHONE)
	private String cellphone;
	
	@Column(name = ColumnName.EMAIL)
	private String email;
	
	@Column(name = ColumnName.ADDRESS)
	private String address;
	
	@ManyToMany
	@JoinTable(name = TableName.ROLE_USER,  
	joinColumns = {@JoinColumn (name = ColumnName.USER_FK)}, 
	inverseJoinColumns = {@JoinColumn (name = ColumnName.ROLE_FK)})
	private Set<Role> roleSet = new HashSet<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	
	private class ColumnName {
		private static final String ID = "ID";
		private static final String NAME = "NAME";
		private static final String PASSWORD = "PASSWORD";
		private static final String CELLPHONE = "CELLPHONE";
		private static final String EMAIL = "EMAIL";
		private static final String ADDRESS = "ADRESS";
		private static final String USER_FK = "USER_FK";
		private static final String ROLE_FK = "ROLE_FK";
	}
	
	public static class TableName {
		static final String USER = "[USER]";
		static final String ROLE_USER = "ROLE_USER";
	}
	
}
