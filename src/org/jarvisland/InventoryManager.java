package org.jarvisland;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class InventoryManager implements ExecutionHandler {
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
	
	public void removeAllItem() {
		//inventory.clear();
		inventory = new ArrayList<String>();
	}
	
	public void reinitialiser() {
		removeAllItem();
		addItem("Bouteille de vin");
		addItem("Lampe de poche");
		addItem("Grappin");
		
	}

	@Override
	public void execute(String commande, ByteArrayOutputStream baos) {
		PrintStream ps = new PrintStream(baos);
		
		if (commande.matches("INVENTAIRE")) {
			ps.println("Inventaire :");
			
			for(String s : inventory) {
				ps.println("- " + s);
			}
		};
	}
}
