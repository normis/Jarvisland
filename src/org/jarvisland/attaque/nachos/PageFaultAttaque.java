package org.jarvisland.attaque.nachos;

import org.jarvisland.attaque.AttaqueTemplate;

public class PageFaultAttaque extends AttaqueTemplate {

	@Override
	public int getDommage() {
		return 20;
	}

	@Override
	public String getDescription() {
		return "Page Fault";
	}

}
