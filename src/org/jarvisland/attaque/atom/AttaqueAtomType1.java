package org.jarvisland.attaque.atom;

import org.jarvisland.attaque.TypeAttaque;

public class AttaqueAtomType1 extends TypeAttaque{
	@Override
	public int getDommage() {
		return 10;
	}

	@Override
	public String getDescription() {
		return "Fork Bomb";
	}
	
}
