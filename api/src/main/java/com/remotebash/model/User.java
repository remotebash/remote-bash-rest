package com.remotebash.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class User {
	
	@Id
	UUID id;
	
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
	
	//TODO RELAÇÃO MANYTOMANY COM ROLE
	
	
	public class ColumnName {
		private static final String NAME = "NAME";
		private static final String PASSWORD = "PASSWORD";
		private static final String CELLPHONE = "CELLPHONE";
		private static final String EMAIL = "EMAIL";
		private static final String ADDRESS = "ADRESS";
	}
}
