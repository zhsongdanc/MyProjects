package com.demussong.security;

public class EncryptErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EncryptErrorException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
