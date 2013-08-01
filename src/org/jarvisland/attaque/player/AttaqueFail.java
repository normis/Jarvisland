package org.jarvisland.attaque.player;

import org.jarvisland.attaque.TypeAttaque;

public class AttaqueFail extends TypeAttaque {

	@Override
	public int getDommage() {
		return 0;
	}

	@Override
	public String getDescription() {
		return "ERROR 404";
	}

}
