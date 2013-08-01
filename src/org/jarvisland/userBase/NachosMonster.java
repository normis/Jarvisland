package org.jarvisland.userBase;

import org.jarvisland.attaque.Attaque;
import org.jarvisland.attaque.nachos.AttaqueNachosType1;
import org.jarvisland.attaque.nachos.AttaqueNachosType2;
import org.jarvisland.attaque.nachos.AttaqueNachosType3;
import org.jarvisland.attaque.nachos.AttaqueNachosType4;

public class NachosMonster extends Monster {
	
	private final int nbAttaque = 4;

	public NachosMonster(String nom, int vie, int level) {
		super(nom, vie, level);
	}

	@Override
	public Attaque getRandomAttaque() {
		int randomNum = 1 + (int)(Math.random()*nbAttaque);
		Attaque attaque = null;
		
		switch(randomNum){
		case 1: attaque = new AttaqueNachosType1();
		case 2: attaque = new AttaqueNachosType2();
		case 3: attaque = new AttaqueNachosType3();
		case 4: attaque = new AttaqueNachosType4();
		}
		
		return attaque;
	}
	

}
