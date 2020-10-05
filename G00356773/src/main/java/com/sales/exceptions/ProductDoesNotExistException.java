package com.sales.exceptions;

@SuppressWarnings("serial")
public class ProductDoesNotExistException extends Exception {

	public ProductDoesNotExistException(String e) {
		super(e);
	}

}