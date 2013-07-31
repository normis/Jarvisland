package org.jarvisland;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jarvisland.userBase.AtomMonsterFactory;
import org.jarvisland.userBase.Attaque;
import org.jarvisland.userBase.Monster;
import org.jarvisland.userBase.MonsterFactory;
import org.junit.Test;

public class MonstreTest {
	
	@Test
	public void testMonstreFactoryConstructeur() {
		MonsterFactory mf = new AtomMonsterFactory();
		Monster unMonstre = mf.getMonstre();
		assertTrue(unMonstre.getVie() == 25);
		assertTrue(unMonstre.getName().equals("Atom Monster"));
	}
	
	@Test
	public void testMonstreFactoryLife() {
		MonsterFactory mf = new AtomMonsterFactory();
		Monster unMonstre = mf.getMonstre();
		
		try{
			unMonstre.dropLife(24);
			assertTrue(unMonstre.getVie() == 1);
			unMonstre.raiseLife(5);
			assertTrue(unMonstre.getVie() == 6);
			unMonstre.dropLife(7);
			unMonstre.dropLife(3);
			assertTrue(unMonstre.getVie() == 0);
			fail();
		}
		catch(Exception e){
			unMonstre.resetLife();
			assertTrue(unMonstre.getVie() == 25);
		}
	}
	
	@Test
	public void testMonstreFactoryAttaque() {
		MonsterFactory mf = new AtomMonsterFactory();
		
		Monster unMonstre = mf.getMonstre();
		Monster unAutreMonstre = mf.getMonstre();
		
		try{
			unMonstre.attaque(unAutreMonstre, null);
			assertTrue(unAutreMonstre.getVie() != 25);
		}
		catch(Exception e){
			
		}
		
	}
}
