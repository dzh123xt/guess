package org.fun.guess.common.exception;

public class GuessServiceException extends GuessBaseException {

	private static final long serialVersionUID = 8183644707085455741L;

	public GuessServiceException() {

	}

	public GuessServiceException(String message) {
		super(message);
	}

	public GuessServiceException(Throwable e) {
		super(e);
	}

	public GuessServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
