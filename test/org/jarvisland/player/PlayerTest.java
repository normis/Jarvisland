package org.jarvisland.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jarvisland.attaque.Attaque;
import org.junit.Test;

public class PlayerTest {
	
	@Test
	public void testPlayerConstructeur() {
		PlayerManager.getInstance().setBaseLife(60);
		assertTrue(PlayerManager.getInstance().getVie() == 60);
		PlayerManager.getInstance().dropLife(70);
		assertTrue(PlayerManager.getInstance().isDead());
	}
}
