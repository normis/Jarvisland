package org.jarvisland.attaque;

import org.jarvisland.lifeform.LifeForm;
import org.jarvisland.lifeform.UserLifeException;

public interface Attaque {
	public abstract void attaque(LifeForm victim, Attaque attackName) throws UserLifeException;
	public int getDommage();
	public String getDescription();
}
