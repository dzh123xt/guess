package org.fun.guess.common.exception;

public class GuessBaseException extends Exception {

	private static final long serialVersionUID = -2489426973938714522L;

	public GuessBaseException() {
		super();
	}

	public GuessBaseException(String message) {
		super(message);
	}

	public GuessBaseException(Throwable cause) {
		super(cause);
	}

	public GuessBaseException(String message, Throwable cause) {
		super(message, cause);
	}

}
