package com.inditex.exception;

public class InvalidProductException extends RuntimeException{

	private static final long serialVersionUID = 1363849454906985289L;
	
	public InvalidProductException(String errorMessage) {
        super(errorMessage);
    }

}
