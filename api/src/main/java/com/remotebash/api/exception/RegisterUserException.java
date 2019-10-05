package com.remotebash.api.exception;

public class RegisterUserException extends RegisterException{

	private static final long serialVersionUID = 1L;

	public RegisterUserException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "Ocorreu um erro ao cadastrar usuário!";
	}
}
