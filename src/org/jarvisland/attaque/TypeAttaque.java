package org.jarvisland.attaque;

import org.jarvisland.userBase.LifeForm;
import org.jarvisland.userBase.UserLifeException;

public abstract class TypeAttaque implements Attaque{
	public void attaque(LifeForm victim, Attaque attackName){
		try {
			victim.dropLife(attackName.getDommage());
		} catch (UserLifeException e) {
			System.out.println(victim.getName() + " est mort.");
		}
	}
	
}
