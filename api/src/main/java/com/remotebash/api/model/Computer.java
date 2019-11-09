package com.remotebash.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Computer.TableName.COMPUTER)
public class Computer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnName.ID)
	private Long id;
	
	@Column(name = ColumnName.MACADDRESS)
	private String macaddress;
	
	@Column(name = ColumnName.IP)
	private String ip;
	
	@Column(name = ColumnName.OPERATIONAL_SYSTEM)
	private String operationalSystem; 
	
	@Column(name = ColumnName.RAM_MEMORY)
	private String ramMemory; 
	
	@Column(name = ColumnName.HD_TOTAL)
	private String hdTotal; 
	
	@Column(name = ColumnName.HD_USAGE)
	private String hdUsage; 
	
	@Column(name = ColumnName.PROCESSOR_BRAND)
	private String processorBrand; 

	@Column(name = ColumnName.PROCESSOR_MODEL)
	private String processorModel;

	@Column(name = ColumnName.PLATFORM)
	private String platform;
	
	public Computer () {}
	
	public Computer(Long id, String macaddress, String ip, String operationalSystem, String ramMemory, String hdTotal,
			String hdUsage, String processorBrand, String processorModel) {
		super();
		this.id = id;
		this.macaddress = macaddress;
		this.ip = ip;
		this.operationalSystem = operationalSystem;
		this.ramMemory = ramMemory;
		this.hdTotal = hdTotal;
		this.hdUsage = hdUsage;
		this.processorBrand = processorBrand;
		this.processorModel = processorModel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMacaddress() {
		return macaddress;
	}

	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOperationalSystem() {
		return operationalSystem;
	}

	public void setOperationalSystem(String operationalSystem) {
		this.operationalSystem = operationalSystem;
	}

	public String getRamMemory() {
		return ramMemory;
	}

	public void setRamMemory(String ramMemory) {
		this.ramMemory = ramMemory;
	}

	public String getHdTotal() {
		return hdTotal;
	}

	public void setHdTotal(String hdTotal) {
		this.hdTotal = hdTotal;
	}

	public String getHdUsage() {
		return hdUsage;
	}

	public void setHdUsage(String hdUsage) {
		this.hdUsage = hdUsage;
	}

	public String getProcessorBrand() {
		return processorBrand;
	}

	public void setProcessorBrand(String processorBrand) {
		this.processorBrand = processorBrand;
	}

	public String getProcessorModel() {
		return processorModel;
	}

	public void setProcessorModel(String processorModel) {
		this.processorModel = processorModel;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public String getPlatform() {
		return this.platform;
	}

	private static class ColumnName {
		private static final String ID = "ID";
		private static final String MACADDRESS = "MACADDRESS";
		private static final String IP = "IP";
		private static final String OPERATIONAL_SYSTEM = "OPERATIONAL_SYSTEM";
		private static final String RAM_MEMORY = "RAM_MEMORY";
		private static final String HD_TOTAL = "HD_TOTAL";
		private static final String HD_USAGE = "HD_USAGE";
		private static final String PROCESSOR_BRAND = "PROCESSOR_BRAND";
		private static final String PROCESSOR_MODEL = "PROCESSOR_MODEL";
		private static final String PLATFORM = "PLATFORM";
	}
	
	public static class TableName {
		static final String COMPUTER = "COMPUTER";
	}

}
