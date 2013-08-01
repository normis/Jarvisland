package org.jarvisland.level.level2;

import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

public class ForetRoom extends AbstractRoom implements Room {

	@Override
	public String look() {
		return "Vous êtes dans une forêt";
	}

	@Override
	public String execute(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	public Room north() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException(
				"Vous apercevez une montagne.");
	}

	public Room south() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException(
				"Vous apercevez un lac");
	}

	public Room east() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("chateau");
	}

	public Room west() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException("Vous apercevez une plaine.");
	}

}
