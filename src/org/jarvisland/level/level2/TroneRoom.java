package org.jarvisland.level.level2;

import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

public class TroneRoom extends AbstractRoom implements Room {

	@Override
	public String look() {
		// TODO Auto-generated method stub
		return "Vous êtes dans la salle du throne";
	}

	@Override
	public String execute(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	public Room north() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("hall");
	}

	public Room south() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException("Vous apercevez un mur");
	}

	public Room east() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("dongeon");
	}

	public Room west() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("cour");
	}

}
