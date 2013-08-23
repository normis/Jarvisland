package org.jarvisland.attaque.nachos;

import org.jarvisland.attaque.AttaqueTemplate;

public class BusErrorAttaque extends AttaqueTemplate {

	@Override
	public int getDommage() {
		return 18;
	}

	@Override
	public String getDescription() {
		return "Bus Error";
	}

}
