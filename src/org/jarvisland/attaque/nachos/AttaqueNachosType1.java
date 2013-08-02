package org.jarvisland.attaque.nachos;

import org.jarvisland.attaque.TypeAttaque;

public class AttaqueNachosType1 extends TypeAttaque {

	@Override
	public int getDommage() {
		return 15;
	}

	@Override
	public String getDescription() {
		return "Segmentation Fault";
	}

}
