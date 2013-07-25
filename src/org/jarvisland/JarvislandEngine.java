package org.jarvisland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.jarvisland.level.LevelEndedException;
import org.jarvisland.levels.room.RoomNotAccessibleException;

/**
 * Moteur du jeu Jarvisland
 * 
 * Il faut simplement instancier la classe et le jeu d�marre.
 * 
 * LevelManager : g�re les niveaux
 * InventoryManager : g�re l'inventaire
 * 
 * Le moteur fait le lien entre les commandes du joueur
 * et les diff�rents Manager de Jarvisland
 * 
 * @author niclupien
 *
 */
public class JarvislandEngine {
	
	/**
	 * Le constructeur prend en param�tre une pi�ce de d�part
	 * et la charge.
	 * 
	 * @param startRoom
	 */
	public JarvislandEngine() {
		System.out.println("=====================================");
		System.out.println("Bienvenue � Jarvisland!");
		System.out.println("Entrez 'aide' pour voir les commandes");
		System.out.println("=====================================");
		System.out.println();
		
		LevelManager.getInstance().nextLevel();
		put(LevelManager.getInstance().getCurrentLevel().look());
	}
	
	/**
	 * Affiche une phrase au joueur.
	 * 
	 * La fonction renvoie aussi un nouveau prompt lorsque le message
	 * a �t� envoy�.
	 * 
	 * @param s
	 */
	private void put(String s) {
		System.out.println(s);
		prompt();
	}

	/**
	 * Demande le input du joueur
	 * 
	 * Le input est ensuite trait� par la pi�ce (room) en cours.
	 */
	private void prompt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(">");
		
		try {
			execute(br.readLine());
		} catch(LevelEndedException lle) {
			checkCompleted();
		} catch (IOException e) {
			System.err.println("Invalid Format!");
		}
	}
	
	/**
	 * Execute une commande entr�e par le joueur.
	 * 
	 * @param commande
	 */
	private void execute(String commande) {
		commande = commande.toUpperCase();
		
		if (commande.matches("NORD|SUD|EST|OUEST")) {
			navigate(commande);
		} else if (commande.matches("INVENTAIRE")) {
			afficherInventaire();
		} else if (commande.matches("AIDE")) {
			afficherAide();
		} else if (commande.matches("(ALLO|BONJOUR|SALUT).*")) {
			put(HelloWorld.SayHi());
		}  else {
			String resultat = LevelManager.getInstance().getCurrentLevel().execute(commande);
			if (checkCompleted() == false)
				put(resultat != null ? resultat : "Je ne comprends pas cette action.");
		}
			
	}
	
	/**
	 * V�rifie si le niveau est compl�t�. S'il l'est, on charge
	 * le prochain niveau.
	 * 
	 * @return completed
	 */
	private boolean checkCompleted() {
		if (LevelManager.getInstance().getCurrentLevel().isCompleted()) {
			LevelManager.getInstance().nextLevel();
			put(LevelManager.getInstance().getCurrentLevel().look());
			return true;
		}
		return false;
	}

	/**
	 * Affiche l'inventaire du joueur
	 */
	private void afficherInventaire() {
		InventoryManager.getInstance().afficher();
		prompt();
	}

	/**
	 * Permet au joueur de se d�placer.
	 * 
	 * @param direction
	 */
	private void navigate(String direction) {
		try {
			LevelManager.getInstance().getCurrentLevel().navigate(direction);
			put(LevelManager.getInstance().getCurrentLevel().look());
		} catch (RoomNotAccessibleException nae) {
			put(nae.getMessage());
		}
	}
	
	/**
	 * Affiche les commandes de Jarvisland
	 */
	private void afficherAide() {
		System.out.println();
		InputStream file = ClassLoader.getSystemResourceAsStream("aide.txt");
		put(new Scanner(file).useDelimiter("\\Z").next());
	}

}
