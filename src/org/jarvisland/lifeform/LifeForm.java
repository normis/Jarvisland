
package org.jarvisland.lifeform;


public interface LifeForm{
	public int getVie();
	public String getName();
	public void resetLife();
	public String attaque(LifeForm user, String nameAttaque) throws OutOfLifeException;
	public void raiseLife(int gainLife); 
	public void dropLife(int loseLife) throws OutOfLifeException;
	public boolean isDead();
}
