package org.jarvisland.lifeform;

import org.jarvisland.attaque.Attaque;

public abstract class Monster implements LifeForm{

	private String nom;
	private int vie;
	private int baseLife;
	
	public Monster(String nom, int vie, int level){
		this.nom = nom;
		this.vie = vie;
		this.baseLife = vie;
	}	
	
	@Override
	public int getVie() {
		return this.vie;
	}

	@Override
	public boolean isDead() {
		if (vie <= 0)
			return true;
		return false;
	}

	@Override
	public String getName() {
		return nom;
	}

	@Override
	public void resetLife() {
		vie = baseLife;
	}

	public String attaque(LifeForm user, String nameAttaque) throws UserLifeException {
			Attaque attaque = getRandomAttaque();
			attaque.attaque(user, attaque);
			return getName() + " a utiliser l'attaque " + attaque.getDescription();
	}
	
	public abstract Attaque getRandomAttaque();

	@Override
	public void dropLife(int loseLife) throws UserLifeException {
		if(!isDead()){
			vie = vie - loseLife;
			if(vie < 0)
				vie = 0;
		}
		else
			throw new UserLifeException("L'usager " + getName() + " est déjà mort");
	}

	@Override
	public void raiseLife(int gainLife) {
		vie = vie + gainLife;
	}

}
