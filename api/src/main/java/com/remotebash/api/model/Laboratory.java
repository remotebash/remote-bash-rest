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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Laboratory.TableName.LABORATORY)
public class Laboratory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnName.ID)
	private Long id;
	
	@Column(name = ColumnName.NAME)
	private String name;

	@Column(name = ColumnName.DESCRIPTION)
	private String description;
	
	@OneToMany(mappedBy = "laboratory", fetch = FetchType.LAZY)
	private Set<Computer> computerSet = new HashSet<>();	
	
	@ManyToOne
	@JoinColumn(name = ColumnName.USER_ID, referencedColumnName = ColumnName.USER_ID)
	private User user; 
	
	public Laboratory() {}
	
	public Laboratory(Long id, String name, String description, Set<Computer> computerSet) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.computerSet = computerSet;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Computer> getComputerSet() {
		return computerSet;
	}

	public void setComputerSet(Set<Computer> computerSet) {
		this.computerSet = computerSet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private static class ColumnName {
		static final String USER_ID = "USER_ID";
		static final String ID = "ID";
		static final String DESCRIPTION = "DESCRIPTION";
		static final String NAME = "NAME";
	}
	
	public static class TableName {
		 static final String LABORATORY = "LABORATORY"; 
	}
}
