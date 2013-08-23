package org.jarvisland.lifeform;

import org.jarvisland.attaque.Attaque;
import org.jarvisland.attaque.AttaqueTemplate;
import org.jarvisland.attaque.nachos.BusErrorAttaque;
import org.jarvisland.attaque.nachos.PageFaultAttaque;
import org.jarvisland.attaque.nachos.SalsaExtraForteAttaque;
import org.jarvisland.attaque.nachos.SegFaultAttaque;

public class NachosMonster extends Monster {

	private final int nbAttaque = 4;

	public NachosMonster(String nom, int vie, int level) {
		super(nom, vie, level);
	}

	@Override
	public AttaqueTemplate getRandomAttaque() {
		int randomNum = 1 + (int) (Math.random() * nbAttaque);
		AttaqueTemplate attaque = null;

		switch (randomNum) {
		case 1:
			attaque = new SegFaultAttaque();
			break;
		case 2:
			attaque = new BusErrorAttaque();
			break;
		case 3:
			attaque = new PageFaultAttaque();
			break;
		default:
			attaque = new SalsaExtraForteAttaque();
		}

		return attaque;
	}

}
