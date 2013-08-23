package org.jarvisland.attaque;

import org.jarvisland.lifeform.LifeForm;
import org.jarvisland.lifeform.OutOfLifeException;

public abstract class AttaqueTemplate implements Attaque{
	public void attaquer(LifeForm victim) throws OutOfLifeException{
			victim.dropLife(getDommage());
	}
}
