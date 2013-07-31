package org.jarvisland.userBase;

public class NachosMonster extends Monster {

	public NachosMonster(String nom, int vie, int level) {
		super(nom, vie, level);
				
		Attaque attaque1 = new Attaque("Segmentation Fault", 30);
		addAttaque(attaque1);
		
		Attaque attaque2 = new Attaque("Bus Error", 20);
		addAttaque(attaque2);
		
		Attaque attaque3 = new Attaque("Page Fault", 25);
		addAttaque(attaque3);
		
		Attaque attaque4 = new Attaque("Salsa extra forte", 40);
		addAttaque(attaque4);
	}
	

}
