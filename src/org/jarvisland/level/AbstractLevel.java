package org.jarvisland.level;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

	public String navigate(String direction) {
		Room nextRoom = null;

		try {
			if (direction.matches("NORD"))
				nextRoom = room.north();
			else if (direction.matches("SUD"))
				nextRoom = room.south();
			else if (direction.matches("EST"))
				nextRoom = room.east();
			else if (direction.matches("OUEST"))
				nextRoom = room.west();
		} catch (RoomNotAccessibleException e) {
			return e.getMessage();
		}

		if (nextRoom != null) {
			room = nextRoom;
			return room.look();
		} else
			return "Vous ne pouvez pas aller dans cette direction.";

	}

	@Override
	public void execute(String commande, ByteArrayOutputStream baos) {
		PrintStream ps = new PrintStream(baos);
		
		commande = commande.toUpperCase();

		if (commande.matches("NORD|SUD|EST|OUEST")) {
			ps.println(navigate(commande));
		} else if (commande.matches("VOIR")) {
			ps.println(room.look());
		} else {
			String result = room.execute(commande);
			if (result != null) ps.println(result);
		}
	}

	@Override
	public String look() {
		return room.look();
	}

	public String changeRoom(String newRoom) {
		room = map.get(newRoom);
		room.initialiser();
		return room.look();
	}

	/**
	 * Nom de la room actuel
	 * 
	 * @return nom
	 */
	public Room getRoom(String room) {
		return map.get(room);
	}

	@Override
	public void initialiserLevel() {
		room = getInitialRoom();
		for(Room r : map.values()) {
			r.initialiser();
		}
		
	}

}
