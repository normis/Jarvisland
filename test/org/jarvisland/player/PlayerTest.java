package org.jarvisland.player;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class PlayerTest {
	
	@Test
	public void testPlayerConstructeur() {
		PlayerManager.getInstance().setBaseLife(60);
		assertTrue(PlayerManager.getInstance().getVie() == 60);
		try{
		PlayerManager.getInstance().dropLife(70);
		fail();
		} catch(DeathException De){
		}
	}
}
