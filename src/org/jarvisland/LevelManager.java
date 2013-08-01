package org.jarvisland;

import java.util.LinkedList;

import org.jarvisland.level.Level;
import org.jarvisland.level.level0.Level0;
import org.jarvisland.level.level1.Level1;
import org.jarvisland.level.level2.Level2;

/**
 * Gestion des niveaux de Jarvisland
 * 
 * Le LevelManager fait le lien entre les niveaux et le moteur du jeu.
 * 
 * Il s'agit d'un singleton car il ne doit pas y avoir plusieurs instances
 * de cette classe.
 * 
 * @author niclupien
 *
 */
public class LevelManager {
	private static LevelManager instance = new LevelManager();
	
	private LinkedList<Level> levels;
	private Level currentLevel;
	
	private LevelManager() {
		levels = new LinkedList<Level>();
		//levels.add(new Level0());
		//levels.add(new Level1());
		levels.add(new Level2());
	}
	
	public static LevelManager getInstance() {
		return instance;
	}
	
	public Level nextLevel() {
		System.out.println();
		
		if (levels.size() == 0) {
			System.out.println("Fin.");
			System.exit(0);
		}
		
		currentLevel = levels.removeFirst();
		
		System.out.println("== " + currentLevel.getName() + " ==");
		System.out.println();
		
		return currentLevel;
	}

	public Level getCurrentLevel() {
		return currentLevel;
	}
	
	public void notifyCurrentLevel(String string) {
		currentLevel.notify(string);
	}

	public void resetLevel() {
		currentLevel.initialiserLevel();
		InventoryManager.getInstance().reinitialiser();
	}
}
