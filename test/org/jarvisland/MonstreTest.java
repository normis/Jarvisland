package org.jarvisland;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jarvisland.userBase.Attaque;
import org.jarvisland.userBase.Monstre;
import org.junit.Test;

public class MonstreTest {
	
	@Test
	public void testMonstreFactoryConstructeur() {
		Monstre unMonstre = new Monstre("MegaMonstre", 20, 2);
		assertTrue(unMonstre.getVie() == 20);
		assertTrue(unMonstre.getName().equals("MegaMonstre"));
	}
	
	@Test
	public void testMonstreFactoryLife() {
		Monstre unMonstre = new Monstre("MegaMonstre", 20, 2);
		
		try{
			unMonstre.dropLife(19);
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
			assertTrue(unMonstre.getVie() == 20);
		}
	}
	
	@Test
	public void testMonstreFactoryAttaque() {
		Monstre unMonstre = new Monstre("MegaMonstre", 20, 2);
		Monstre unAutreMonstre = new Monstre("MegaTest", 30, 2);
		
		Attaque attaque1 = new Attaque("test", 10);
		unMonstre.addAttaque(attaque1);
		
		try{
			unMonstre.attaque(unAutreMonstre, null);
			assertTrue(unAutreMonstre.getVie() == 20);
		
			unMonstre.removeAttaque(attaque1);
			unMonstre.attaque(unAutreMonstre, null);
			fail();
		}
		catch(Exception e){
			
		}
		
	}
}
