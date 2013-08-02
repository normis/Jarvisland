package org.jarvisland.attaque.player;

import org.jarvisland.attaque.TypeAttaque;

public class AttaquePied extends TypeAttaque {

	@Override
	public int getDommage() {
		return 15;
	}

	@Override
	public String getDescription() {
		return "Coup de pied";
	}

}
