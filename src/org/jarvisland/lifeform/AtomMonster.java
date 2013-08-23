package org.jarvisland.lifeform;

import org.jarvisland.attaque.AttaqueTemplate;
import org.jarvisland.attaque.atom.Blizzard;
import org.jarvisland.attaque.atom.ForkBomb;
import org.jarvisland.attaque.atom.LaserBeam;

public class AtomMonster extends Monster {

	private final int nbAttaque = 3;

	public AtomMonster(String nom, int vie, int level) {
		super(nom, vie, level);
	}

	@Override
	public AttaqueTemplate getRandomAttaque() {
		int randomNum = 1 + (int) (Math.random() * nbAttaque);
		AttaqueTemplate attaque = null;

		switch (randomNum) {
		case 1:
			attaque = new ForkBomb();
			break;
		case 2:
			attaque = new LaserBeam();
			break;
		default:
			attaque = new Blizzard();
		}

		return attaque;
	}

}
