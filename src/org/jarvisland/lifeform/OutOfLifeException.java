package org.jarvisland.lifeform;

@SuppressWarnings("serial")
public class OutOfLifeException extends Exception {
	public OutOfLifeException(String message) {
		super(message);
	}

	public OutOfLifeException() {
		super("Vous êtes mort");
	}
}
