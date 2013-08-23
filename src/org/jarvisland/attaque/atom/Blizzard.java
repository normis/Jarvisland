package org.jarvisland.attaque.atom;

import org.jarvisland.attaque.AttaqueTemplate;

public class Blizzard extends AttaqueTemplate{

	@Override
	public int getDommage() {
		return 6;
	}

	@Override
	public String getDescription() {
		return "Blizzard";
	}

}
