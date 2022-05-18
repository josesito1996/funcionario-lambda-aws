package com.javatechie.aws.lambda.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8835406841348110836L;

	
	public NotFoundException(String msg) {
		super(msg);
	}
}
