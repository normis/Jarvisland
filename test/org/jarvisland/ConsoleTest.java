package org.jarvisland;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ConsoleTest {

	@Test
	public void testVoir() {
		String in = "voir";
		String out = "log.txt";
		
		//try {
			new JarvislandEngine(System.in, System.out);
			//new JarvislandEngine((InputStream) new ByteArrayInputStream(in.getBytes()),new PrintStream(out) );
		//} catch (FileNotFoundException e) {
			//e.printStackTrace();
		//}
		
		System.out.println(out);
		//assertEquals(, "a");
		//fail("Not yet implemented");
	}

}
