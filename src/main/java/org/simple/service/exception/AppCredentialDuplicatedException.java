package org.simple.service.exception;

public class AppCredentialDuplicatedException extends RuntimeException{
	
	private static final long serialVersionUID = 6223907268299370068L;

	public AppCredentialDuplicatedException(String msg) {
		super(msg);
	}
}
