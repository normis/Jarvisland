package org.jarvisland.attaque.nachos;

import org.jarvisland.attaque.AttaqueTemplate;

public class SalsaExtraForteAttaque extends AttaqueTemplate {

	@Override
	public int getDommage() {
		return 25;
	}

	@Override
	public String getDescription() {
		return "Salsa extra forte";
	}

}
