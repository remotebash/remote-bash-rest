package com.remotebash.api.exception;

public abstract class UserException extends Throwable {
	
	private static final long serialVersionUID = -6027937808735719202L;
	
	private final String message;

<<<<<<< HEAD:api/src/main/java/com/remotebash/api/exception/UserException.java
	public UserException(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMessage(String message) {
		return message;
=======
	public RegisterException(String mensagem) {
		this.message = mensagem;
>>>>>>> bc759d184e61d0e430d06254e1ff4a162f5c7f6a:api/src/main/java/com/remotebash/api/exception/RegisterException.java
	} 
	
}
