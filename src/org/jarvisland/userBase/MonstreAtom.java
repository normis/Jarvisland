package org.jarvisland.userBase;

import java.util.ArrayList;

public class MonstreAtom {
	
	MonstreFactory monstreAtom;

	public MonstreAtom(){
		
		monstreAtom = new MonstreFactory("Monstre Atom", 25, 1);
		
		Attaque attaque1 = new Attaque("Fork Bomb", 10);
		monstreAtom.addAttaque(attaque1);
		
		Attaque attaque2 = new Attaque("Thunder Bolt", 5);
		monstreAtom.addAttaque(attaque2);
		
		Attaque attaque3 = new Attaque("Blizard", 6);
		monstreAtom.addAttaque(attaque3);
	}
	
	
	public MonstreFactory getMonsterFactory(){
		return monstreAtom;
	}

}
