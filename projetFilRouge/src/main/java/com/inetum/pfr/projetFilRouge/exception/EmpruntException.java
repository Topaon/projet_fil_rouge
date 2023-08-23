package com.inetum.pfr.projetFilRouge.exception;

public class EmpruntException extends RuntimeException {

	public EmpruntException() {
	}
	
	public EmpruntException(String message) {
		super(message);
	}

	public EmpruntException(String message, Throwable cause) {
		super(message, cause);
	}

}
