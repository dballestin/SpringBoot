package com.inetum.elementos.model.exceptions;

public class ElementoJuegoException extends RuntimeException {

	private static final long serialVersionUID = -6708815588077462216L;

	public ElementoJuegoException() {
	}

	public ElementoJuegoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ElementoJuegoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ElementoJuegoException(String message) {
		super(message);
	}

	public ElementoJuegoException(Throwable cause) {
		super(cause);
	}
}
