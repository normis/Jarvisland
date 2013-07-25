package org.jarvisland;

import java.util.ArrayList;

/**
 * Gestionnaire d'inventaire du joueur.
 * 
 * Contient une Facade de ArrayList pour simplifier son utilisation
 * @link http://en.wikipedia.org/wiki/Facade_pattern
 * 
 * Il s'agit d'un singleton car il ne doit pas y avoir
 * plusieurs instances de cette classe. Il n'y a qu'un seul
 * inventaire dans tout le jeu.
 * 
 * @author niclupien
 *
 */
public class InventoryManager {
	private ArrayList<String> inventory;
	
	private static InventoryManager instance = new InventoryManager();
	
	private InventoryManager() {
		inventory = new ArrayList<String>();
	}
	
	public static InventoryManager getInstance() {
		return instance;
	}
	
	public void addItem(String item) {
		inventory.add(item);
	}
	
	public boolean hasItem(String item) {
		return inventory.contains(item);
	}
	
	public void removeItem(String item) {
		inventory.remove(item);
	}
	
	public void afficher() {
		System.out.println("Inventaire :");
		
		for(String s : inventory) {
			System.out.println("- " + s);
		}
	}
}
