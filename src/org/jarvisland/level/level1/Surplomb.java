package org.jarvisland.level.level1;

import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

public class Surplomb extends AbstractRoom {
	boolean utiliserLampe = false;
	boolean pritRoche = false;
	boolean utiliserRoche = false;

	@Override
	public String look() {
		if (utiliserLampe)
			return "Vous vous retrouvez dans une grotte.\n" + "Il y a mur ";
		else
			return "Il fait noir";
	}

	@Override
	public String execute(String s) {
		if (s.matches("PRENDRE.* ROCHE") && utiliserLampe)
			pritRoche = true;
		else if (s.matches("UTILISER.* LAMPE DE POCHE")){
			utiliserLampe = true;
			return "Il fait maintenant clair.";
		}
		else if (s.matches("UTILISER.* ROCHE") && pritRoche){
			utiliserRoche = true;
			return "Roche : Aaaaaaaaaoutch!\n";
		}
			
		return null;
	}

	public Room south() throws RoomNotAccessibleException {
		if (utiliserLampe)
			throw new RoomNotAccessibleException("Vous voyez un mur de roche");
		else
			throw new RoomNotAccessibleException("Il fait noir");
	}

	public Room east() throws RoomNotAccessibleException {
		if (utiliserLampe)
			throw new RoomNotAccessibleException(
					"Il y a un tas de roche avec une qui a une inscription.\n"
							+ "L'inscription mentionne Cliff.");
		else
			throw new RoomNotAccessibleException("Il fait noir");
	}

	public Room west() throws RoomNotAccessibleException {
		if (utiliserLampe)
			throw new RoomNotAccessibleException(
					"Vous voyez le puis d'ou vous venez, voulez-vous vraiment y retourner ?");
		else
			throw new RoomNotAccessibleException("Il fait noir");
	}

	public Room north() throws RoomNotAccessibleException {
		if (utiliserLampe && !utiliserRoche)
			throw new RoomNotAccessibleException(
					"Vous apercevez quelques planches pourites qui semblent assez faible.");
		else if(utiliserLampe && utiliserRoche)
			throw new RoomNotAccessibleException(LevelManager.getInstance().changeRoom("Enigme"));
		else
			throw new RoomNotAccessibleException("Il fait noir");
	}
}
