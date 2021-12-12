package com.myproject.webtools.exception;

public class PropertyException extends Exception {

	public PropertyException(String message)
	{
		super(message);
	}
	
	public PropertyException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
