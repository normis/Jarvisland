package org.jarvisland;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jarvisland.attaque.Attaque;
import org.jarvisland.attaque.AttaqueTemplate;
import org.jarvisland.attaque.nachos.SegFaultAttaque;
import org.jarvisland.lifeform.LifeForm;
import org.jarvisland.lifeform.MonsterFactory;
import org.jarvisland.lifeform.NachosMonsterFactory;
import org.jarvisland.lifeform.OutOfLifeException;
import org.junit.Test;

public class AttaqueTest {
	
	@Test
	public void testAttaqueConstructor() {
		Attaque attaque = new SegFaultAttaque();
		assertTrue(attaque.getDommage() == 15);
		assertTrue(attaque.getDescription().equals("Segmentation Fault"));
	}
	
	@Test
	public void testAttaque() {
		AttaqueTemplate attaque = new SegFaultAttaque();
		MonsterFactory mf = new NachosMonsterFactory();
		LifeForm monsterTest = mf.getMonstre();
		
		try {
			attaque.attaquer(monsterTest);
			assertEquals(135, monsterTest.getVie());
		} catch (OutOfLifeException e) {
			fail();
		}
	}
	
	@Test
	public void testOverAttaque() {
		AttaqueTemplate attaque = new SegFaultAttaque();
		MonsterFactory mf = new NachosMonsterFactory();
		LifeForm monsterTest = mf.getMonstre();
		
		try {
			attaque.attaquer(monsterTest);
			attaque.attaquer(monsterTest);
			attaque.attaquer(monsterTest);
			attaque.attaquer(monsterTest);
			attaque.attaquer(monsterTest);
			attaque.attaquer(monsterTest);
			attaque.attaquer(monsterTest);
			attaque.attaquer(monsterTest);
		} catch (OutOfLifeException e) {
			fail();
		}
	}

}
