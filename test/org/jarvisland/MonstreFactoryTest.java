package org.jarvisland;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jarvisland.userBase.Attaque;
import org.jarvisland.userBase.MonstreFactory;
import org.junit.Test;

public class MonstreFactoryTest {
	
	@Test
	public void testMonstreFactoryConstructeur() {
		MonstreFactory unMonstre = new MonstreFactory("MegaMonstre", 20, 2);
		assertTrue(unMonstre.getVie() == 20);
		assertTrue(unMonstre.getName().equals("MegaMonstre"));
	}
	
	@Test
	public void testMonstreFactoryLife() {
		MonstreFactory unMonstre = new MonstreFactory("MegaMonstre", 20, 2);
		
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
		MonstreFactory unMonstre = new MonstreFactory("MegaMonstre", 20, 2);
		MonstreFactory unAutreMonstre = new MonstreFactory("MegaTest", 30, 2);
		
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
