package org.jarvisland;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jarvisland.userBase.Attaque;
import org.junit.Test;

public class AttaqueTest {
	
	@Test
	public void testAttaqueConstructeur() {
		Attaque laser = new Attaque("Laser beam", 20);
		assertTrue(laser.getNbrDegats() == 20);
		assertTrue(laser.getNom().equals("Laser beam"));
	}
}
