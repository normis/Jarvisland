package org.jarvisland.level.level2;

import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;
import org.jarvisland.InventoryManager;

public class CuisineRoom extends AbstractRoom implements Room {
	
	private boolean porteBarrer = true;

	@Override
	public String look() {
		return "Vous êtes dans la cuisine";
	}

	@Override
	public String execute(String s) {
		if (s.matches("PRENDRE.* COUTEAU")) {
			InventoryManager.getInstance().addItem("couteau");
			return "Vous ramassez le couteau.";
		}
		return null;
	}

	public Room north() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException("Vous apercevez un comptoir sur lequel repose un couteau tranchant.");
	}

	public Room south() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("hall");
	}

	public Room east() throws RoomNotAccessibleException {
		if (InventoryManager.getInstance().hasItem("cle tour") || porteBarrer) {
			porteBarrer = false;
			InventoryManager.getInstance().removeItem("cle tour");
			System.out.println("Vous utilisez la clé pour débarrer la porte.\n");
			return LevelManager.getInstance().getCurrentLevel().getRoom("tour");
		} else {
			throw new RoomNotAccessibleException(
					"La porte semble fermée à clé.");
		}
	}

	public Room west() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("chambre");
	}

}
