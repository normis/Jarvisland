package org.jarvisland.userBase;

@SuppressWarnings("serial")
public class UserLifeException extends Exception {
	public UserLifeException(String message) {
		super(message);
	}

	public UserLifeException() {
		super("L'user est déjà mort");
	}
}
