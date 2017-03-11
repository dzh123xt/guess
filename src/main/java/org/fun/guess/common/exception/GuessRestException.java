package org.fun.guess.common.exception;

public class GuessRestException extends GuessBaseException {

	private static final long serialVersionUID = -7109450773110109590L;

	public GuessRestException() {

	}

	public GuessRestException(String message) {
		super(message);
	}

	public GuessRestException(Throwable e) {
		super(e);
	}

}
