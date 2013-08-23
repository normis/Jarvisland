package org.jarvisland.attaque.player;

import org.jarvisland.attaque.AttaqueTemplate;

public class AttaquePoing extends AttaqueTemplate {

	@Override
	public int getDommage() {
		return 10;
	}

	@Override
	public String getDescription() {
		return "Coup de poing";
	}

}
