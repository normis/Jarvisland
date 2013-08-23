package org.jarvisland.attaque.player;

import org.jarvisland.attaque.AttaqueTemplate;

public class AttaqueSpecial extends AttaqueTemplate {

	@Override
	public int getDommage() {
		return 9000;
	}

	@Override
	public String getDescription() {
		return "Super pouvoir";
	}

}
