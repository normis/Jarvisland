package org.jarvisland.userBase;

public interface UserBase{
	public int getVie();
	public String getName();
	public void resetLife();
	public String attaque(UserBase user, String nameAttaque) throws Exception;
	public void raiseLife(int gainLife); 
	public void dropLife(int loseLife) throws Exception;
	public boolean isDead();
	public void addAttaque(Attaque attaque);
	public void removeAttaque(Attaque attaque);
}
