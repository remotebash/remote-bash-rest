package com.remotebash.api.exception;

public abstract class RegisterException extends Throwable {
	
	private static final long serialVersionUID = -6027937808735719202L;
	
	private final String message;

	public RegisterException(String mensagem) {
		this.message = mensagem;
	} 
	
}
