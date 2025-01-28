package com.breno.envhazardtracker.shared.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class BadRequestException extends EnvHazardException {

	@Serial
	private static final long serialVersionUID = -5330068136795055851L;

	public BadRequestException(final String message) {
		super(HttpStatus.BAD_REQUEST.value(), message);
	}

}
