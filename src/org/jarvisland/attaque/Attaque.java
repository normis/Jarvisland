package org.jarvisland.attaque;

import org.jarvisland.userBase.LifeForm;
import org.jarvisland.userBase.UserLifeException;

public interface Attaque {
	public abstract void attaque(LifeForm victim, Attaque attackName) throws UserLifeException;
	public int getDommage();
	public String getDescription();
}
