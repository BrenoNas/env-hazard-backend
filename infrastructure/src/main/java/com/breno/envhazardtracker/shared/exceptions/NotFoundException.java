package com.breno.envhazardtracker.shared.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class NotFoundException extends EnvHazardException {

	@Serial
	private static final long serialVersionUID = -6870732210014274010L;

	public NotFoundException(final String message) {
		super(HttpStatus.NOT_FOUND.value(), message);
	}

}
