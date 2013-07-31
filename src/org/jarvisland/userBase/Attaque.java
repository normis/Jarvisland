package org.jarvisland.userBase;

public class Attaque {
	private String nom;
	private int nbrDegats;
	
	public Attaque(String nom, int nbrDegats){
		this.nom = nom;
		this.nbrDegats = nbrDegats;
	}

	public String getNom() {
		return nom;
	}

	public int getNbrDegats() {
		return nbrDegats;
	}
}
