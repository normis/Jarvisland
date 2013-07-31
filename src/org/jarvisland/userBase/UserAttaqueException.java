package org.jarvisland.userBase;

@SuppressWarnings("serial")
public class UserAttaqueException extends Exception {
	
	public UserAttaqueException(String message) {
		super(message);
	}

	public UserAttaqueException() {
		super("Le monstre ne possède aucune attaque");
	}

}
