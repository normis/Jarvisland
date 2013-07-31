package org.jarvisland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.jarvisland.level.LevelEndedException;
import org.jarvisland.levels.room.RoomNotAccessibleException;

/**
 * Moteur du jeu Jarvisland
 * 
 * Il faut simplement instancier la classe et le jeu démarre.
 * 
 * LevelManager : gère les niveaux InventoryManager : gère l'inventaire
 * 
 * Le moteur fait le lien entre les commandes du joueur et les différents
 * Manager de Jarvisland
 * 
 * @author niclupien
 * 
 */
public class JarvislandEngine {

	private BufferedReader bufferedReader;
	/**
	 * Le constructeur prend en paramètre une pièce de départ et la charge.
	 * 
	 * @param startRoom
	 * @throws RoomNotAccessibleException
	 */
	public JarvislandEngine(BufferedReader br) {
		System.out.println("=====================================");
		System.out.println("Bienvenue à Jarvisland!");
		System.out.println("Entrez 'aide' pour voir les commandes");
		System.out.println("=====================================");
		System.out.println();
		
		this.bufferedReader = br;

		LevelManager.getInstance().nextLevel();
		put(LevelManager.getInstance().getCurrentLevel().look());
	}

	/**
	 * Affiche une phrase au joueur.
	 * 
	 * La fonction renvoie aussi un nouveau prompt lorsque le message a été
	 * envoyé.
	 * 
	 * @param s
	 * @throws RoomNotAccessibleException
	 */
	private void put(String s) {
		System.out.println(s);
		prompt();
	}

	/**
	 * Demande le input du joueur
	 * 
	 * Le input est ensuite traité par la pièce (room) en cours.
	 * 
	 * @throws RoomNotAccessibleException
	 */
	private void prompt() {

		try {
			System.out.print(">");
			execute(bufferedReader.readLine());
		} catch (LevelEndedException lle) {
			checkCompleted();
		} catch (IOException e) {
			System.err.println("Invalid Format!");
		}
	}

	/**
	 * Execute une commande entrée par le joueur.
	 * 
	 * @param commande
	 * @throws RoomNotAccessibleException
	 */
	private void execute(String commande) {
		commande = commande.toUpperCase();

		if (commande.matches("INVENTAIRE")) {
			afficherInventaire();
		} else if (commande.matches("AIDE")) {
			afficherAide();
		} else if (commande.matches("(ALLO|BONJOUR|SALUT).*")) {
			put(HelloWorld.SayHi());
		} else {
			String test = LevelManager.getInstance().getCurrentLevel()
					.execute(commande);
			
			put(test != null ? test : "La commande n'est pas valide" );
		}

	}

	/**
	 * Vérifie si le niveau est complété. S'il l'est, on charge le prochain
	 * niveau.
	 * 
	 * @return completed
	 * @throws RoomNotAccessibleException
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
	 * 
	 * @throws RoomNotAccessibleException
	 */
	private void afficherInventaire() {
		InventoryManager.getInstance().afficher();
		prompt();
	}

	/**
	 * Affiche les commandes de Jarvisland
	 * 
	 * @throws RoomNotAccessibleException
	 */
	private void afficherAide() {
		System.out.println();
		InputStream file = ClassLoader.getSystemResourceAsStream("aide.txt");
		put(new Scanner(file).useDelimiter("\\Z").next());
	}

}
