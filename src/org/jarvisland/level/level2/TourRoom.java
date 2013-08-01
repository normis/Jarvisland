package org.jarvisland.level.level2;

import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

public class TourRoom extends AbstractRoom implements Room {

	@Override
	public String look() {
		// TODO Auto-generated method stub
		return "Vous êtes dans la tour";
	}

	@Override
	public String execute(String s) {
		// TODO Auto-generated method stub
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
