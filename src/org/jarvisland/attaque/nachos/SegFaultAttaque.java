package org.jarvisland.attaque.nachos;

import org.jarvisland.attaque.AttaqueTemplate;

public class SegFaultAttaque extends AttaqueTemplate {

	@Override
	public int getDommage() {
		return 15;
	}

	@Override
	public String getDescription() {
		return "Segmentation Fault";
	}

}
