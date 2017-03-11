package org.fun.guess.common.exception;

/**
 * 公共的RuntimeException.可以不用Catch
 * 
 * @author dengzhihong
 *
 */
public class GuessBaseRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 4936584037852850496L;

	public GuessBaseRuntimeException(String message) {
		super(message);
	}

	public GuessBaseRuntimeException(Throwable e) {
		super(e);
	}

	public GuessBaseRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
