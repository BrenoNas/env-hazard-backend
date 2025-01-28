package com.breno.envhazardtracker.shared.exceptions;

public abstract class EnvHazardException extends Exception {

	private static final long serialVersionUID = -7482635401716007171L;

	private final int code;


	public EnvHazardException(final int code, final String message) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

}
