package com.inditex.exception;

public class DateException extends RuntimeException{

	private static final long serialVersionUID = 1363849454906985288L;
	
	public DateException(String errorMessage) {
        super(errorMessage);
    }

}
