package org.onlineshoppingportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.TEMPORARY_REDIRECT,
				reason=" User already logged in",
				code=HttpStatus.TEMPORARY_REDIRECT)
public class AlreadyLoginException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AlreadyLoginException() {
	super("Already logged in user tried to access signup/login page");
	}
}
