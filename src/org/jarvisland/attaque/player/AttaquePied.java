package org.jarvisland.attaque.player;

import org.jarvisland.attaque.AttaqueTemplate;

public class AttaquePied extends AttaqueTemplate {

	@Override
	public int getDommage() {
		return 15;
	}

	@Override
	public String getDescription() {
		return "Coup de pied";
	}

}
