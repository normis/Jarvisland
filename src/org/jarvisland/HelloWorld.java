package org.jarvisland;

public class HelloWorld {
	public static String SayHi() {
		String[] greet = {
				"Bonjour � vous.",
				"Salutation.",
				"Quel belle temp�rature avons-nous ces temps-ci!",
				"Aurevoir"
		};
		int n = (int)(Math.random()*greet.length);
		return greet[n];
	}
}
