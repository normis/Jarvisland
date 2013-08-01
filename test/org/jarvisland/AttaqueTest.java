package org.jarvisland;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jarvisland.attaque.Attaque;
import org.jarvisland.attaque.nachos.AttaqueNachosType1;
import org.jarvisland.player.PlayerManager;
import org.jarvisland.userBase.LifeForm;
import org.jarvisland.userBase.MonsterFactory;
import org.jarvisland.userBase.NachosMonsterFactory;
import org.jarvisland.userBase.UserLifeException;
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
		
		try {
			attaque.attaque(monsterTest, attaque);
			assertEquals(120, monsterTest.getVie());
		} catch (UserLifeException e) {
			fail();
		}
	}
	
	@Test
	public void testOverAttaque() {
		Attaque attaque = new AttaqueNachosType1();
		MonsterFactory mf = new NachosMonsterFactory();
		LifeForm monsterTest = mf.getMonstre();
		
		try {
			attaque.attaque(monsterTest, attaque);
			attaque.attaque(monsterTest, attaque);
			attaque.attaque(monsterTest, attaque);
			attaque.attaque(monsterTest, attaque);
			attaque.attaque(monsterTest, attaque);
			attaque.attaque(monsterTest, attaque);
			fail();
		} catch (UserLifeException e) {
		}
	}

}
