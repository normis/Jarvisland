package org.jarvisland;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import org.jarvisland.level.LevelEndedException;
import org.jarvisland.levels.room.RoomNotAccessibleException;
import org.jarvisland.player.DeathException;
import org.jarvisland.player.PlayerManager;

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
	private PrintStream printStream;
	private ArrayList<ExecutionHandler> handlers = new ArrayList<ExecutionHandler>();

	// private int nbTours = 0;

	/**
	 * Le constructeur prend en paramètre une pièce de départ et la charge.
	 * 
	 * @param startRoom
	 * @throws RoomNotAccessibleException
	 */
	public JarvislandEngine(InputStream is, PrintStream ps) {
		System.out.println("=====================================");
		System.out.println("Bienvenue à Jarvisland!");
		System.out.println("Entrez 'aide' pour voir les commandes");
		System.out.println("=====================================");
		System.out.println();

		this.bufferedReader = new BufferedReader(new InputStreamReader(is));
		this.printStream = ps;
		
		handlers.add(InventoryManager.getInstance());
		handlers.add(PlayerManager.getInstance());
		handlers.add(new AideHandler());
		handlers.add(new HelloWorldHandler());
		
		InventoryManager.getInstance().reinitialiser();
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
		if (s.length() == 0)
			printStream.println("Commande invalide.");
		else
			printStream.println(s);
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
		// ++nbTours;
		try {
			printStream.print(">");
			execute(bufferedReader.readLine());
		} catch (LevelEndedException lle) {
			checkCompleted();
		} catch (DeathException death) {
			checkDeath();
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
	public void execute(String commande) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		commande = commande.toUpperCase();
		for(ExecutionHandler h : handlers) h.execute(commande, baos);
		LevelManager.getInstance().getCurrentLevel().execute(commande, baos);
		put(baos.toString());
	}

	/**
	 * Vérifie si le niveau est complété. S'il l'est, on charge le prochain
	 * niveau.
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
	 * Vérifie si le niveau est complété. S'il l'est, on charge le prochain
	 * niveau.
	 * 
	 * @return completed
	 */
	private boolean checkDeath() {
		if (PlayerManager.getInstance().getVie() == 0) {
			System.out.println(PlayerManager.getInstance().mourir());
			LevelManager.getInstance().resetLevel();
			PlayerManager.getInstance().resetLife();
			put(LevelManager.getInstance().getCurrentLevel().look());
			return true;
		}
		return false;
	}

}
