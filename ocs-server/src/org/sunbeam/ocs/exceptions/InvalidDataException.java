package org.sunbeam.ocs.exceptions;

public class InvalidDataException extends Exception {
	
	private String message;

	//CONSTRUCTORS
	
	public InvalidDataException() {
	}
	
	public InvalidDataException(String message) {
		this.message = message;
	} 
	
	
	
}
