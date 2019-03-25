package com.bit.mysite.exception;

public class UserDAOException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserDAOException() {
		super("User Not Found");
	}
}
