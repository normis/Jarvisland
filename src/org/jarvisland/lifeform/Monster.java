package org.jarvisland.lifeform;

import org.jarvisland.attaque.AttaqueTemplate;

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

	public String attaque(LifeForm user, String nameAttaque) throws OutOfLifeException {
			AttaqueTemplate attaque = getRandomAttaque();
			attaque.attaquer(user);
			return getName() + " a utiliser l'attaque " + attaque.getDescription();
	}
	
	public abstract AttaqueTemplate getRandomAttaque();

	@Override
	public void dropLife(int loseLife) throws OutOfLifeException {
		if(!isDead()){
			vie = vie - loseLife;
			if(vie < 0)
				vie = 0;
		}
		else
			throw new OutOfLifeException("L'usager " + getName() + " est déjà mort");
	}

	@Override
	public void raiseLife(int gainLife) {
		vie = vie + gainLife;
	}

}
