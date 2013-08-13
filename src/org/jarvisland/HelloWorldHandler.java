package org.jarvisland;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloWorldHandler implements ExecutionHandler {
	private String greet() {
		String[] greetings = {
				"Bonjour à vous.",
				"Salutation.",
				"Quel belle température avons-nous ces temps-ci!",
				"Au revoir!"
		};
		int n = (int)(Math.random()*greetings.length);
		return greetings[n];
	}

	@Override
	public void execute(String commande, ByteArrayOutputStream baos) {
		PrintStream ps = new PrintStream(baos);
		if (commande.matches("(ALLO|BONJOUR|SALUT).*"))
			ps.println(greet());
	}
}
