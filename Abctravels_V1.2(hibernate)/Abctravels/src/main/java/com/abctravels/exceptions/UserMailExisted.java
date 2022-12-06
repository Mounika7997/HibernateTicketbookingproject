package com.abctravels.exceptions;

public class UserMailExisted  extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserMailExisted(String message){
		super(message);
	}
	

}
