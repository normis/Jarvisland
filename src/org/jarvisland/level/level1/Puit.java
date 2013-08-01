package org.jarvisland.level.level1;

import org.jarvisland.InventoryManager;
import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

public class Puit extends AbstractRoom {

	boolean utiliserGrappin = false;

	@Override
	public String look() {
		return "Tu tombe dans se qui semble etre un puit en pierre. \n"
				+ "Le sol approche a grande vitesse.";
	}

	@Override
	public String execute(String s) {
		if (s.matches("UTILISER.* GRAPPIN")) {
			utiliserGrappin = true;
			InventoryManager.getInstance().removeItem("Grappin");
			LevelManager.getInstance().notifyCurrentLevel("outOfPuit");
			return "Vous avez eviter la mort! \n"
					+ "Vous etes acrocher au mur.\n"
					+ "Vous remonter a l'aide du grappin jusqu'a un surplomb. \n\n"
					+ LevelManager.getInstance().getCurrentLevel().changeRoom("Surplomb");
		}
		return null;
	}

	public Room south() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException(
				"Les murs defilent a trop grande vitesse pour s'agripper.");
	}

	public Room east() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException(
				"Les murs defilent a trop grande vitesse pour s'agripper.");
	}

	public Room west() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException(
				"Les murs defilent a trop grande vitesse pour s'agripper.");
	}

	public Room north() throws RoomNotAccessibleException {
			throw new RoomNotAccessibleException(
					"Les murs defilent a trop grande vitesse pour s'agripper.");
	}
}
