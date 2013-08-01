package org.jarvisland;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jarvisland.attaque.Attaque;
import org.jarvisland.attaque.AttaqueNachosType1;
import org.jarvisland.player.PlayerManager;
import org.jarvisland.userBase.LifeForm;
import org.jarvisland.userBase.MonsterFactory;
import org.jarvisland.userBase.NachosMonsterFactory;
import org.junit.Test;

public class AttaqueTest {
	
	@Test
	public void testAttaqueConstructor() {
		Attaque attaque = new AttaqueNachosType1();
		assertTrue(attaque.getDommage() == 30);
		assertTrue(attaque.getDescription().equals("Segmentation Fault"));
	}
	
	@Test
	public void testAttaque() {
		Attaque attaque = new AttaqueNachosType1();
		MonsterFactory mf = new NachosMonsterFactory();
		LifeForm monsterTest = mf.getMonstre();
		attaque.attaque(monsterTest, attaque);
		assertEquals(120, monsterTest.getVie());
	}

}
