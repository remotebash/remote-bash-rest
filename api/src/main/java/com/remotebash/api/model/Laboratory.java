package com.remotebash.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Laboratory.TableName.LABORATORY)
public class Laboratory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnName.LABORATORY_ID)
	private Long id;
	
	@Column(name = ColumnName.FLOOR)
	private String floor;
	
	@Column(name = ColumnName.CAPACITY)
	private String capacity;
	
	public Laboratory() {}
	
	public Laboratory(Long id, String floor, String capacity) {
		super();
		this.id = id;
		this.floor = floor;
		this.capacity = capacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		static final String LABORATORY_ID = "ID";
		static final String FLOOR = "FLOOR";
		static final String CAPACITY = "CAPACITY";
	}
	
	public static class TableName {
		 static final String LABORATORY = "LABORATORY"; 
	}
}
