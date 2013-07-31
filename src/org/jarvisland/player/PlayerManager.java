/**
 * 
 */
package org.jarvisland.player;

/**
 * Classe servant à gérer la situation des joueurs (changement de niveau,
 * perte de vie, la mort, etc...). Contient la liste des attaques.
 * @author normis / Simon
 *
 */

import java.util.List;

import org.jarvisland.userBase.Attaque;
import org.jarvisland.userBase.UserBase;
import org.jarvisland.userBase.UserLifeException;

public class PlayerManager implements UserBase{
	private final int changeVie;
	private int vieInitial;
	private int vie;
	private int level;
	private boolean dead;
	private String name;
	private List<Attaque> listAttaque;
	private static PlayerManager instance = new PlayerManager();

	
	private PlayerManager() {
		changeVie = 10;
		vieInitial = 50;
		level = 0;
		dead = false;
		vie = vieInitial;
	}

	public static PlayerManager getInstance() {
		return instance;
	}

	@Override
	public int getVie() {
		return vie;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isDead() {
		return dead;
	}

	@Override
	public void resetLife() {
		vie = vieInitial;
	}
	
	@Override
	public void dropLife(int dommage) {
		vie -= dommage;
		if(vie <= 0)
		{
			vie = 0;
			dead = true;
		}
	}

	@Override
	public void addAttaque(Attaque atk) {
		listAttaque.add(atk);
	}

	@Override
	public void removeAttaque(Attaque atk) {
		listAttaque.remove(atk);
	}

	@Override
	public void raiseLife(int gainLife) {
		vie += gainLife;
		if(vie >= vieInitial){
			vie = vieInitial;
		}
		
	}

	public void changedLevel(int newLevel) {
		level = newLevel;
	}

	public String attaque(UserBase user, String nameAttaque) throws UserLifeException {
		int dommage = 0;
		String attaque = "";
		for(Attaque atk : listAttaque)
		{
			if (atk.getNom().contains(nameAttaque))
			{
				dommage = atk.getNbrDegats();
				attaque = atk.getNom();
			}
			//TODO: ne pas faire 0 de dommage si le non de l'attaque n'existe pas
		}
		user.dropLife(dommage);
		
		return "Vous avez utilisez l'attaque: " + attaque;
	}

	public void setBaseLife(int life) {
		vieInitial = life;
		vie = life;
	}
	
	public void AfficherStat()
	{
		System.out.println("Votre nombre de vie:est de "+ vie + " sur " + vieInitial);
		System.out.println("Vos attaques sont: ");
		for(Attaque atk :listAttaque)
		{
			System.out.println(atk.getNom() + " qui fais " + atk.getNbrDegats());
		}
	}
}