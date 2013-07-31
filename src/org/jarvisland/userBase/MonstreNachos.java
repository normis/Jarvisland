package org.jarvisland.userBase;

public class MonstreNachos {
	
	Monstre monstreNachos;

	public MonstreNachos(){
		
		monstreNachos = new Monstre("Monstre Nachos", 150, 10);
		
		Attaque attaque1 = new Attaque("Segmentation Fault", 30);
		monstreNachos.addAttaque(attaque1);
		
		Attaque attaque2 = new Attaque("Bus Error", 20);
		monstreNachos.addAttaque(attaque2);
		
		Attaque attaque3 = new Attaque("Page Fault", 25);
		monstreNachos.addAttaque(attaque3);
		
		Attaque attaque4 = new Attaque("Salsa extra forte", 40);
		monstreNachos.addAttaque(attaque4);
	}
	
	
	public Monstre getMonsterFactory(){
		return monstreNachos;
	}

}
