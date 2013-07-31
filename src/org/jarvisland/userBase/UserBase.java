package org.jarvisland.userBase;

public interface UserBase{
	public int getVie();
	public String getName();
	public void resetLife();
	public void attaque(UserBase user);
	public void raiseLife(int gainLife); 
	public void dropLife(int loseLife);
	public void changedLevel(int newLevel);
	public boolean isDead();
	public void addAttaque(Attaque attaque);
	public void removeAttaque(Attaque attaque);
}