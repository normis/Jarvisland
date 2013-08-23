package org.jarvisland.attaque.player;

import org.jarvisland.attaque.AttaqueTemplate;

public class AttaqueFail extends AttaqueTemplate {

	@Override
	public int getDommage() {
		return 0;
	}

	@Override
	public String getDescription() {
		return "Erreur 404";
	}

}
