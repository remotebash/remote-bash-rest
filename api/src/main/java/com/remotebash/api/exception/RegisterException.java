package com.remotebash.api.exception;

public class RegisterException extends Throwable {
	
	private static final long serialVersionUID = -6027937808735719202L;
	
	private final String message;

	public RegisterException(String mensagem) {
		this.message = mensagem;
	}

	@Override   
	public String getMessage() {
		return "Ocorreu um erro ao realizar Cadastro!";
	}

	
	
}
