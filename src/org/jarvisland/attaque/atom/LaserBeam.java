package org.jarvisland.attaque.atom;

import org.jarvisland.attaque.AttaqueTemplate;

public class LaserBeam extends AttaqueTemplate{

	@Override
	public int getDommage() {
		return 5;
	}

	@Override
	public String getDescription() {
		return "Leaser Beam";
	}

}
