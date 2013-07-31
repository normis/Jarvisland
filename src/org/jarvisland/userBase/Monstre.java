package org.jarvisland.userBase;

import java.util.ArrayList;

public class Monstre implements UserBase{

	private String nom;
	private int vie;
	private int level;
	private int baseLife;
	private ArrayList<Attaque> arrAttaque;
	
	public Monstre(String nom, int vie, int level){
		this.nom = nom;
		this.vie = vie;
		this.baseLife = vie;
		this.level = level;
		arrAttaque = new ArrayList<Attaque>();
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

	public String attaque(UserBase user, String nameAttaque) throws Exception {
		if(arrAttaque.size() > 0){
			int tableauSize = arrAttaque.size() - 1;
			int randomNum = 0 + (int)(Math.random()*tableauSize);
			
			Attaque attaque = arrAttaque.get(randomNum);
			user.dropLife(attaque.getNbrDegats());
			return user.getName() + " a utiliser l'attaque " + attaque.getNom();
		}
		else
			throw new Exception("Le monstre n'a aucune attaque");
	}

	@Override
	public void dropLife(int loseLife) throws Exception {
		if(!isDead()){
			vie = vie - loseLife;
			if(vie < 0)
				vie = 0;
		}
		else
			throw new Exception("L'ennemie est déjà mort");
	}

	@Override
	public void addAttaque(Attaque attaque) {
		arrAttaque.add(attaque);
	}

	@Override
	public void removeAttaque(Attaque attaque) {
		arrAttaque.remove(attaque);
	}

	@Override
	public void raiseLife(int gainLife) {
		vie = vie + gainLife;
	}

}
