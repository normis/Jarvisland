package org.jarvisland;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class AideHandler implements ExecutionHandler {

	@Override
	public void execute(String commande, ByteArrayOutputStream baos) {
		PrintStream ps = new PrintStream(baos);
		if (commande.matches("AIDE")) {
			ps.println();
			InputStream file = ClassLoader.getSystemResourceAsStream("aide.txt");
			ps.println(new Scanner(file).useDelimiter("\\Z").next());
		} 
	}

}
