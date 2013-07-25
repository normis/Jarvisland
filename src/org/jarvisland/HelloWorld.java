package org.jarvisland;

public class HelloWorld {
	public static String SayHi() {
		String[] greet = {
				"Bonjour à vous.",
				"Salutation.",
				"Quel belle température avons-nous ces temps-ci!",
				"Aurevoir"
		};
		int n = (int)(Math.random()*greet.length);
		return greet[n];
	}
}
