package org.jarvisland.userBase;

import org.jarvisland.attaque.Attaque;
import org.jarvisland.attaque.AttaqueAtomType1;
import org.jarvisland.attaque.AttaqueAtomType2;
import org.jarvisland.attaque.AttaqueAtomType3;

public class AtomMonster extends Monster {
	
	private final int nbAttaque = 3;

	public AtomMonster(String nom, int vie, int level) {
		super(nom, vie, level);
	}

	@Override
	public Attaque getRandomAttaque() {
		int randomNum = 1 + (int)(Math.random()*nbAttaque);
		Attaque attaque = null;
		
		switch(randomNum){
		case 1: attaque = new AttaqueAtomType1();
		case 2: attaque = new AttaqueAtomType2();
		case 3: attaque = new AttaqueAtomType3();
		}
		
		return attaque;
	}

}
