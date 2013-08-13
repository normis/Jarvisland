/**
 * 
 */
package org.jarvisland.player;

/**
 * Classe servant à gérer la situation des joueurs (changement de niveau,
 * perte de vie, la mort, etc...). Contient la liste des attaques.
 *
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.jarvisland.ExecutionHandler;
import org.jarvisland.attaque.Attaque;
import org.jarvisland.attaque.player.AttaqueFail;
import org.jarvisland.attaque.player.AttaquePied;
import org.jarvisland.attaque.player.AttaquePoing;
import org.jarvisland.attaque.player.AttaqueSpecial;
import org.jarvisland.lifeform.LifeForm;
import org.jarvisland.lifeform.UserLifeException;

public class PlayerManager implements LifeForm, ExecutionHandler{
	private final int vieInitiale = 50;
	private int pointDeVie = 50;
	private boolean estMort = false;
	private ArrayList<Attaque> attaques;
	private static PlayerManager instance = new PlayerManager();

	
	private PlayerManager() {
		pointDeVie = vieInitiale;
		attaques = new ArrayList<Attaque>();
		attaques.add(new AttaquePied());
		attaques.add(new AttaquePoing());
		attaques.add(new AttaqueFail());
		attaques.add(new AttaqueSpecial());
	}

	public static PlayerManager getInstance() {
		return instance;
	}

	@Override
	public int getVie() {
		return pointDeVie;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public boolean isDead() {
		return estMort;
	}

	@Override
	public void resetLife() {
		pointDeVie = vieInitiale;
	}
	
	@Override
	public void dropLife(int dommage) throws DeathException{
		pointDeVie -= dommage;
		if(pointDeVie <= 0)
		{
			pointDeVie = 0;
			estMort = false;
			throw new DeathException();
		}
	}

	public void addAttaque(Attaque atk) {
		attaques.add(atk);
	}

	public void removeAttaque(Attaque atk) {
		attaques.remove(atk);
	}

	@Override
	public void raiseLife(int gainLife) {
		pointDeVie += gainLife;
		if(pointDeVie >= vieInitiale){
			pointDeVie = vieInitiale;
		}
		
	}

	public String attaque(LifeForm user, String nameAttaque) throws UserLifeException {
		int dommage = 0;
		String attaque = null;
		for(Attaque atk : attaques)
		{
			if (atk.getDescription().toUpperCase().contains(nameAttaque))
			{
				dommage = atk.getDommage();
				attaque = atk.getDescription();
				break;
			}
			//TODO: ne pas faire 0 de dommage si le non de l'attaque n'existe pas
		}
		if(attaque != null){
			user.dropLife(dommage);
			return "Vous avez utilisez l'attaque: " + attaque;
		}
		return attaque;
	}
	
	public void afficherStats(PrintStream ps)
	{
		ps.println("Votre nombre de vie est de "+ pointDeVie + " sur " + vieInitiale);
		ps.println("Vos attaques sont: ");
		
		listeAttaque(ps);
	}

	public String mourir() {
		return "** Game over **";
	}

	public void listeAttaque(PrintStream ps) {
		for(Attaque atk : attaques)
		{
			ps.println("- " + atk.getDescription() + " - " + atk.getDommage() + " de dommage");
		}
	}

	public void setBaseLife(int i) {
		pointDeVie = i;
	}

	@Override
	public void execute(String commande, ByteArrayOutputStream baos) {
		PrintStream ps = new PrintStream(baos);
		
		if (commande.matches("STATS")) {
			afficherStats(ps);
		}
	}
}