package org.jarvisland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.jarvisland.lifeform.Monster;
import org.jarvisland.lifeform.OutOfLifeException;
import org.jarvisland.player.DeathException;
import org.jarvisland.player.PlayerManager;

public class CombatManager {
	private BufferedReader bufferedReader;
	private PrintStream printStream;
	private PlayerManager player = PlayerManager.getInstance();
	private Monster monster;

	public CombatManager(Monster m) {
		monster = m;
		this.bufferedReader = new BufferedReader(new InputStreamReader(
				System.in));
		this.printStream = System.out;
	}

	public void demarrerCombat() throws DeathException {
		System.out.println("Vous êtes maintenent dans un combat contre " + monster.getName());
		player.afficherStats(System.out);
		while (true) {
			prompt();
			if (player.isDead())
				throw new DeathException();
			if (monster.isDead())
				break;
		}
		System.out.println("Combat réussi, vous gagné " + getRandomExp() + " points d'experiences.\n");
	}

	private void lancerAttaque(String s) {
		try {
			String result = player.attaque(monster, s);
			if (result != null) {
				System.out.println(result);
				System.out.println(monster.attaque(player, null));
				System.out.println("Vos points de vie : " + player.getVie()
						+ "\t Vie du monstre : " + monster.getVie());
			} else
				put("L'attaque n'existe pas");
		} catch (OutOfLifeException e) {
			System.out.println(e);
		}
	}

	private void execute(String commande) {
		commande = commande.toUpperCase();
		
		if (commande.matches("AIDE"))
			player.listeAttaque(System.out);
		else
			lancerAttaque(commande);
	}

	private void put(String s) {
		printStream.println(s);
		prompt();
	}

	private void prompt() {
		try {
			printStream.print(">");
			execute(bufferedReader.readLine());
		} catch (IOException e) {
			System.err.println("Invalid Format!");
		}
	}
	
	private int getRandomExp() {
		return 4; // chosen by fair dice roll, guaranteed to be random
	}
}
