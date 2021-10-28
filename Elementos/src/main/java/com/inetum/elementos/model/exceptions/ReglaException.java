package com.inetum.elementos.model.exceptions;

public class ReglaException extends RuntimeException {

	private static final long serialVersionUID = 1717312525167725245L;
	
	public ReglaException() {
	}

	public ReglaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ReglaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReglaException(String message) {
		super(message);
	}

	public ReglaException(Throwable cause) {
		super(cause);
	}
}
