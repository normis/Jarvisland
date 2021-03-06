package org.jarvisland.level.level2;

import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

public class ChateauRoom extends AbstractRoom implements Room {

	@Override
	public String look() {
		return "Vous arrivez à la grande porte du chateau. Vous reconnaissez les cris.\n" +
				"Il s'agit de la princesse Jarvis. Elle semble en grand péril.";
	}

	@Override
	public String execute(String s) {
		return null;
	}

	public Room north() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("chambre");
	}

	public Room south() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("cour");
	}

	public Room east() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("hall");
	}

	public Room west() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("foret");
	}

}
