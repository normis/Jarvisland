package org.jarvisland.attaque;

import org.jarvisland.userBase.LifeForm;

public interface Attaque {
	public abstract void attaque(LifeForm victim, Attaque attackName);
	public int getDommage();
	public String getDescription();
}
