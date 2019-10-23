package com.remotebash.api.exception;

public abstract class UserException extends Throwable {
	
	private static final long serialVersionUID = -6027937808735719202L;
	
	private final String message;

	public UserException(String mensagem) {
		this.message = mensagem;
	}

	public String getMessage(String message) {
		return message;
	}
	
}
