package org.jarvisland.attaque.player;

import org.jarvisland.attaque.TypeAttaque;

public class AttaquePoing extends TypeAttaque {

	@Override
	public int getDommage() {
		return 10;
	}

	@Override
	public String getDescription() {
		return "Punch";
	}

}
