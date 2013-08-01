package org.jarvisland.attaque;

public class AttaqueNachosType3 extends TypeAttaque {

	@Override
	public int getDommage() {
		return 25;
	}

	@Override
	public String getDescription() {
		return "Page Fault";
	}

}
