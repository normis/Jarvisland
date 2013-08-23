package org.jarvisland.attaque.atom;

import org.jarvisland.attaque.AttaqueTemplate;

public class ForkBomb extends AttaqueTemplate{
	@Override
	public int getDommage() {
		return 10;
	}

	@Override
	public String getDescription() {
		return "Fork Bomb";
	}
	
}
