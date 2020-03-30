package com.dps.common.utils;

public class DpsRegistryException extends Exception {

	private String errorCode;
	private String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DpsRegistryException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public DpsRegistryException(String message) {
		super();
		this.message = message;
	}

}
