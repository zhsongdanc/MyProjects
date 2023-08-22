package com.demussong.security;

public class DecryptErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DecryptErrorException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
