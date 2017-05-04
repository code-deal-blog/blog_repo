package org.onlineshoppingportal.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.onlineshoppingportal.exceptions.AlreadyLoginException;
import org.onlineshoppingportal.exceptions.NoOrderFoundException;
import org.onlineshoppingportal.exceptions.ProductOutOfStockException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NoHandlerFoundException.class)
	public String pageNotFoundHandler(HttpServletRequest request, Exception ex)
	{
		System.out.println("requested url ="+request.getRequestURL());
		System.out.println("Exception ="+ex.getMessage());
		return "404";
	}
	
	@ExceptionHandler(ProductOutOfStockException.class)
	public String productOutOfStock(ProductOutOfStockException ex)
	{
		return "outOfStock";
	}
	
	@ExceptionHandler(NoOrderFoundException.class)
	public String noOrderFound(NoOrderFoundException ex)
	{
		return "noOrder";
	}
	
	@ExceptionHandler(AlreadyLoginException.class)
	public String AlreadyLogin(AlreadyLoginException ex)
	{
		return "redirect:/productList";
	}
	
	@ExceptionHandler(SQLException.class)
	public String internalServerProblem(SQLException ex)
	{
		return "serverError";
	}
}
