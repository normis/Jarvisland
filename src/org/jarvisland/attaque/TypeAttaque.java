package org.jarvisland.attaque;

import org.jarvisland.lifeform.LifeForm;
import org.jarvisland.lifeform.UserLifeException;

public abstract class TypeAttaque implements Attaque{
	public void attaque(LifeForm victim, Attaque attackName) throws UserLifeException{
			victim.dropLife(attackName.getDommage());
	}
}
