package org.jarvisland.levels.room;

/**
 * Lors d'un déplecement, il se peut que l'on ne change pas de pièce.
 * 
 * Dans ce cas, on utilise cette exception pour en communiquer la raison.
 * 
 * @author niclupien
 * 
 */
@SuppressWarnings("serial")
public class RoomNotAccessibleException extends Exception {
	public RoomNotAccessibleException(String message) {
		super(message);
	}

	public RoomNotAccessibleException() {
		super("Vous ne pouvez pas aller dans cette direction.");
	}
}
