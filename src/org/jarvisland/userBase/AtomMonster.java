package org.jarvisland.userBase;

public class AtomMonster extends Monster {

	public AtomMonster(String nom, int vie, int level) {
		super(nom, vie, level);
		
		Attaque attaque1 = new Attaque("Fork Bomb", 10);
		addAttaque(attaque1);
		
		Attaque attaque2 = new Attaque("Thunder Bolt", 5);
		addAttaque(attaque2);
		
		Attaque attaque3 = new Attaque("Blizard", 6);
		addAttaque(attaque3);
	}

}
