
package org.jarvisland.userBase;

public interface LifeForm{
	public int getVie();
	public String getName();
	public void resetLife();
	public String attaque(LifeForm user, String nameAttaque) throws UserAttaqueException, UserLifeException;
	public void raiseLife(int gainLife); 
	public void dropLife(int loseLife) throws UserLifeException;
	public boolean isDead();
	public void addAttaque(Attaque attaque);
	public void removeAttaque(Attaque attaque);
}