package org.jarvisland.level.level2;

import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;
import org.jarvisland.userBase.Monster;

public class HallRoom extends AbstractRoom implements Room {

	Monster atom;
	
	@Override
	public String look() {
		// TODO Auto-generated method stub
		return "Vous êtes dans le hall";
	}

	@Override
	public String execute(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	public Room north() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("cuisine");
	}

	public Room south() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("trone");
	}

	public Room east() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException("Vous apercevez un mur");
	}

	public Room west() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("chateau");
	}

}
