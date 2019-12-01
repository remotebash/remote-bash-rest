package com.remotebash.api.model;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class Command {
	private String idCommand;
	private Long idComputer;
	private String operationalSystem;
	private String command;
	private String result;
	private String start;
	private String end;
	private Long userId;
	private boolean isExecuted;
	
	public Command() {
	}

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

	public String getOperationalSystem() {
		return operationalSystem;
	}

	public void setOperationalSystem(String operationalSystem) {
		this.operationalSystem = operationalSystem;
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

	public String getStart() {
		return start;
	}

	public void setStart(Date start) {
		if(start == null) {this.start = null; return;};
		java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		this.start = sdf.format(start);
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		if(end == null) {this.end = null; return;};
		java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		this.end = sdf.format(end);
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean isExecuted() {
		return isExecuted;
	}

	public void setIsExecuted(boolean isExecuted) {
		this.isExecuted = isExecuted;
	}

	public String validateCommandToExecute() {
		String warning = StringUtils.EMPTY;
		
		if (this.getUserId() == null) {
			warning = "UserID não pode ser null.\n";
		}
		if (this.getCommand() == null) {
			warning += "O Comando não pode ser null.\n";
		}else {
			if (this.getCommand().trim().length() == 0) {
				warning += "O Comando não pode ser vazio.\n";
			}	
		}
		if (this.getIdComputer() == null) {
			warning += "O IdComputer não pode ser null.\n";
		}

		return warning;
	}

}
