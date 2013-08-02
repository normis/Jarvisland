package org.jarvisland.lifeform;

@SuppressWarnings("serial")
public class UserLifeException extends Exception {
	public UserLifeException(String message) {
		super(message);
	}

	public UserLifeException() {
		super("Vous êtes mort");
	}
}
