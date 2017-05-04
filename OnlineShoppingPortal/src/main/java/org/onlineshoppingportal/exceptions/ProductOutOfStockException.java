package org.onlineshoppingportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,
				reason="Product Out Of Stock",
				code=HttpStatus.NOT_FOUND)
public class ProductOutOfStockException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProductOutOfStockException() {
		super("Product Out Of Stock");
	}
}
