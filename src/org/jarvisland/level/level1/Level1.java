package org.jarvisland.level.level1;

import org.jarvisland.InventoryManager;
import org.jarvisland.level.AbstractLevel;
import org.jarvisland.levels.room.Room;

public class Level1 extends AbstractLevel {
	boolean outOfPuit = false;
	boolean outOfSurplomb = false;
	boolean outOfEnigme = false;

	public Level1() {
		map.put("someRule", new Puit());
		room = map.get("someRule");
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
		System.out.println("notify");
		if (event.equals("outOfPuit")) {
			outOfPuit = true;
			new Surplomb();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Niveau Un";// u r falling down
	}

	@Override
	public Room getRoom(String room){
		return map.get(room);
		
	}
}
