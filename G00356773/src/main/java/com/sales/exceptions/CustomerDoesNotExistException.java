package com.sales.exceptions;

@SuppressWarnings("serial")
public class CustomerDoesNotExistException extends Exception {

	public CustomerDoesNotExistException(String e) {
		super(e);
	}

}