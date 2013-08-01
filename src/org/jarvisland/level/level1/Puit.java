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
		return "Vous êtes en chute libre. Autour de vous se trouve un mur \n" +
				"de pierre circulaire. Le sol approche a grande vitesse, \n" +
				"il faut agir rapidement.";
	}

	@Override
	public String execute(String s) {
		if (s.matches("UTILISER.* GRAPPIN")) {
			utiliserGrappin = true;
			InventoryManager.getInstance().removeItem("Grappin");
			LevelManager.getInstance().notifyCurrentLevel("outOfPuit");
			String look = LevelManager.getInstance().getCurrentLevel().changeRoom("Surplomb");
			
			return "Vous venez d'eviter la mort! Vous vous acrochez au \n" +
					"mur et vous remontez à l'aide du grappin jusqu'à un surplomb.\n" + look;
		}
		return null;
	}

	public Room south() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException(
				"Les murs defilent a trop grande vitesse pour s'agripper.");
	}

	public Room east() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException(
				"Les murs sont trop glissants. Vous ne pouvez pas vous agripper.");
	}

	public Room west() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException(
				"Les murs sont trop glissants. Vous ne pouvez pas vous agripper.");
	}

	public Room north() throws RoomNotAccessibleException {
			throw new RoomNotAccessibleException(
					"Les murs sont trop glissants. Vous ne pouvez pas vous agripper.");
	}

	@Override
	public void initialiser() {
		utiliserGrappin = false;		
	}
}
