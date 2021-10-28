package com.inetum.elementos.model.exceptions;

public class PartidaException extends RuntimeException {
	
	private static final long serialVersionUID = 688237540988383065L;

	public PartidaException() {
	}

	public PartidaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PartidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PartidaException(String message) {
		super(message);
	}

	public PartidaException(Throwable cause) {
		super(cause);
	}
}
