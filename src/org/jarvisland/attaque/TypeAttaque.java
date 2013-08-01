package org.jarvisland.attaque;

import org.jarvisland.userBase.LifeForm;
import org.jarvisland.userBase.UserLifeException;

public abstract class TypeAttaque implements Attaque{
	public void attaque(LifeForm victim, Attaque attackName) throws UserLifeException{
			victim.dropLife(attackName.getDommage());
	}
}
