package org.jarvisland;

import static org.junit.Assert.assertTrue;

import org.jarvisland.level.level0.Level0;
import org.jarvisland.level.level0.TutorialRoom;
import org.junit.Test;

public class LevelTest {

	@Test
	public void testStatingLevel() {
		Level0 l0 = new Level0();
		assertTrue( l0.getRoom("tutorial") instanceof TutorialRoom);	
	}

}
