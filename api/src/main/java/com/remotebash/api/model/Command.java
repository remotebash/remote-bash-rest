package com.remotebash.api.model;

import java.util.Date;

public class Command {
	private String idCommand;	
	private Long idComputer;
	private String platform;
	private String command;
	private String result;
	private Date start;
	private Date end;
	private Long userId;
	private boolean isExecuted;
	
	public String getIdCommand() {
		return idCommand;
	}
	public void setIdCommand(String idCommand) {
		this.idCommand = idCommand;
	}
	public Long getIdComputer() {
		return idComputer;
	}
	public void setIdComputer(Long idComputer) {
		this.idComputer = idComputer;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUser(Long userId) {
		this.userId = userId;
	}
	public boolean isExecuted() {
		return isExecuted;
	}
	public void setExecuted(boolean isExecuted) {
		this.isExecuted = isExecuted;
	}
	
	
	
}
