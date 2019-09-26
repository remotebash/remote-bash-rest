package com.remotebash.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Laboratory.TableName.LABORATORY)
public class Laboratory {

	@Id
	@GeneratedValue
	@Column(name = ColumnName.ID )
	private UUID id;
	
	@Column(name = ColumnName.FLOOR)
	private String floor;
	
	@Column(name = ColumnName.CAPACITY)
	private String capacity;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	private static class ColumnName {
		static final String ID = "ID";
		static final String FLOOR = "FLOOR";
		static final String CAPACITY = "CAPACITY";
	}
	
	public static class TableName {
		 static final String LABORATORY = "LABORATORY"; 
	}
}
