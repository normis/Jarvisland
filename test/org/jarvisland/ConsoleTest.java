package org.jarvisland;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;

import org.junit.Test;

public class ConsoleTest {

	@Test
	public void testVoir() {
		String s = "a";
		new JarvislandEngine(new BufferedReader(null));
		
		
		assertEquals(s, "a");
		//fail("Not yet implemented");
	}

}
