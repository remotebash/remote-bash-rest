package com.remotebash.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = User.TableName.USER)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnName.USER_ID)
	private Long id;
	
	@Column(name = ColumnName.NAME)
	private String name;
	
	@JsonIgnore
	@Column(name = ColumnName.PASSWORD)
	private String password;
	
	@Column(name = ColumnName.CELLPHONE)
	private String cellphone;
	
	@Column(name = ColumnName.EMAIL)
	private String email;
	
	@Column(name = ColumnName.ADDRESS)
	private String address;
	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = TableName.ROLE_USER,  
	joinColumns = {@JoinColumn (name = ColumnName.USER_ID)}, 
	inverseJoinColumns = {@JoinColumn (name = ColumnName.ROLE_ID_FK)})
	private Set<Role> roleSet = new HashSet<>();
	
	public User() {}
	
	public User(Long id, String name, String password, String cellphone, String email, String address,
			Set<Role> roleSet) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.cellphone = cellphone;
		this.email = email;
		this.address = address;
		this.roleSet = roleSet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		private static final String USER_ID = "USER_ID";
		private static final String NAME = "NAME";
		private static final String PASSWORD = "PASSWORD";
		private static final String CELLPHONE = "CELLPHONE";
		private static final String EMAIL = "EMAIL";
		private static final String ADDRESS = "ADRESS";
		private static final String ROLE_ID_FK = "ROLE_ID";
	}
	
	public static class TableName {
		static final String USER = "[USER]";
		static final String ROLE_USER = "ROLE_USER";
	}
	
}
