package org.onlineshoppingportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,
				reason=" No order found for user",
				code=HttpStatus.NOT_FOUND)
public class NoOrderFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NoOrderFoundException() {
		super("No Order found for logged in user");
	}
}
