package org.jarvisland.level;

import java.util.HashMap;
import java.util.Map;

import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

/**
 * 
 * @author niclupien
 *
 */
public abstract class AbstractLevel implements Level {
	protected Room room;
	protected Map<String, Room> map = new HashMap<String, Room>();
	
	
	public String navigate(String direction) throws RoomNotAccessibleException {
		Room nextRoom = null;
		
		if (direction.matches("NORD")) nextRoom = room.north();
		else if (direction.matches("SUD")) nextRoom = room.south();
		else if (direction.matches("EST")) nextRoom = room.east();
		else if (direction.matches("OUEST")) nextRoom = room.west();
		
		if (nextRoom != null)
			room = nextRoom;
		else
			throw new RoomNotAccessibleException();
		
		return room.look();
	}
	
	@Override
	public String execute(String commande) throws RoomNotAccessibleException {
		commande = commande.toUpperCase();
		
		if (commande.matches("NORD|SUD|EST|OUEST")) {
			return navigate(commande);
		} else if (commande.matches("VOIR")) {
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
