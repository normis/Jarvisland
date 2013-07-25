package org.jarvisland.level;

import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

/**
 * 
 * @author niclupien
 *
 */
public abstract class AbstractLevel implements Level {
	private Room room;
	
	public AbstractLevel(Room room) {
		this.room = room;
	}
	
	public void navigate(String direction) throws RoomNotAccessibleException {
		Room nextRoom = null;
		
		if (direction.matches("NORD")) nextRoom = room.north();
		else if (direction.matches("SUD")) nextRoom = room.south();
		else if (direction.matches("EST")) nextRoom = room.east();
		else if (direction.matches("OUEST")) nextRoom = room.west();
		
		if (nextRoom != null)
			room = nextRoom;
		else
			throw new RoomNotAccessibleException();
	}
	
	@Override
	public String execute(String commande) {
		commande = commande.toUpperCase();
		
		if (commande.matches("VOIR")) {
			return room.look();
		} else {
			return room.execute(commande);
		}
	}

	@Override
	public String look() {
		return room.look();
	}

}
