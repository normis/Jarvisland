package org.jarvisland.level.level2;

import org.jarvisland.InventoryManager;
import org.jarvisland.LevelManager;
import org.jarvisland.level.LevelEndedException;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

public class TourRoom extends AbstractRoom implements Room {

	@Override
	public String look() {
		return ("\nVous voyez la princesse Jarvis attachée sur une chaise.\n"
				+ "Il vous faudrait quelque chose de coupant pour la libérer.");
	}

	@Override
	public String execute(String s) {
		if (s.matches("UTILISER.* COUTEAU")) {
			if (InventoryManager.getInstance().hasItem("couteau")) {
				InventoryManager.getInstance().removeItem("couteau");

				System.out.println();
				System.out.println("Vous avez sauvé la princesse Jarvis.");
				System.out.println("Fin!");

				throw new LevelEndedException();

				/*
				 * return
				 * "\nVous êtes parvenu à détacher la princesse Jarvis !\n" +
				 * "Vous devez maintenant vous échappez du château!";
				 */
			} else
				return "Vous ne possèdez pas de couteau.";
		}
		return null;
	}

	public Room north() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException("Vous apercevez un mur");
	}

	public Room south() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException("Vous apercevez un mur");
	}

	public Room east() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException("Vous apercevez un mur");
	}

	public Room west() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("cuisine");
	}

}
