package org.jarvisland.attaque.player;

import org.jarvisland.attaque.TypeAttaque;

public class AttaqueSpecial extends TypeAttaque {

	@Override
	public int getDommage() {
		return 9000;
	}

	@Override
	public String getDescription() {
		return "IT'S OVER 9000!!!";
	}

}
