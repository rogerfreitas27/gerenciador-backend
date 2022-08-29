package com.gerenciador.backend.exception;

public class MessageExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;
    private String message;
    
	public MessageExceptionHandler(String message) {
	this.message=message;	
	}
	
	
	


	public String getMessage() {
		return message;
	}
	
	
	
	
	
	

}
