package org.jarvisland.attaque;

public class AttaqueNachosType1 extends TypeAttaque {

	@Override
	public int getDommage() {
		return 30;
	}

	@Override
	public String getDescription() {
		return "Segmentation Fault";
	}

}
