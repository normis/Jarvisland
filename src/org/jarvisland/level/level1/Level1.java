package org.jarvisland.level.level1;

import org.jarvisland.InventoryManager;
import org.jarvisland.level.AbstractLevel;
import org.jarvisland.levels.room.Room;

public class Level1 extends AbstractLevel {
	boolean outOfPuit = false;
	boolean outOfSurplomb = false;
	boolean outOfEnigme = false;

	public Level1() {
		map.put("Puit", new Puit());
		map.put("Surplomb", new Surplomb());
		map.put("Enigme", new Enigme());
		room = map.get("Puit");
		InventoryManager.getInstance().addItem("Bouteille de vin");
		InventoryManager.getInstance().addItem("Lampe de poche");
		InventoryManager.getInstance().addItem("Grappin");
	}

	@Override
	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return outOfPuit && outOfSurplomb && outOfEnigme;
	}

	@Override
	public void notify(String event) {
		if (event.equals("outOfPuit"))
			outOfPuit = true;
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Niveau Un";// u r falling down
	}
}
