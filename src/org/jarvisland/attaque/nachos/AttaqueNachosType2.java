package org.jarvisland.attaque.nachos;

import org.jarvisland.attaque.TypeAttaque;

public class AttaqueNachosType2 extends TypeAttaque {

	@Override
	public int getDommage() {
		return 20;
	}

	@Override
	public String getDescription() {
		return "Bus Error";
	}

}
