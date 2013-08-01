package org.jarvisland.userBase;

import org.jarvisland.attaque.Attaque;

public interface LifeForm{
	public int getVie();
	public String getName();
	public void resetLife();
	public String attaque(LifeForm user, String nameAttaque) throws UserLifeException;
	public void raiseLife(int gainLife); 
	public void dropLife(int loseLife) throws UserLifeException;
	public boolean isDead();
}
