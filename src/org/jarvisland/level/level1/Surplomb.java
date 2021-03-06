package org.jarvisland.level.level1;

import org.jarvisland.InventoryManager;
import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

public class Surplomb extends AbstractRoom {
	boolean utiliserLampe = false;
	boolean pritRoche = false;
	boolean utiliserRoche = false;
	boolean veutTomber = false;

	@Override
	public String look() {
		if (utiliserLampe)
			return "Vous vous retrouvez dans une grotte.";
		else
			return "Il fait noir";
	}

	@Override
	public String execute(String s) {
		if (s.matches("PRENDRE.* (ROCHE|CLIFF)") && utiliserLampe && !pritRoche) {
			pritRoche = true;
			InventoryManager.getInstance().addItem("Cliff");
			return "Vous prenez la roche.";
		} else if (s.matches("(UTILISER|ALLUMER).* LAMPE DE POCHE")) {
			utiliserLampe = true;
			return "Il fait maintenant clair.";
		} else if (s.matches("UTILISER.* CLIFF") && pritRoche && !utiliserRoche) {
			utiliserRoche = true;
			LevelManager.getInstance().notifyCurrentLevel("outOfSurplomb");
			return "Vous lancez la roche dans le mur de planches.\n"
					+ "Roche : Aaaaaaaaaoutch!\n"
					+ "Etrange... vous reprenez Cliff.";
		} else if (s.matches("OUI") && veutTomber) {
			LevelManager.getInstance().notifyCurrentLevel("estMort");
			return null;
		}

		return null;
	}

	public Room south() throws RoomNotAccessibleException {
		if (utiliserLampe)
			throw new RoomNotAccessibleException("Vous voyez un mur de roches");
		else
			throw new RoomNotAccessibleException("Il fait noir");
	}

	public Room east() throws RoomNotAccessibleException {
		if (utiliserLampe)
			throw new RoomNotAccessibleException(
					"Vous apercevez un tas de roches dont l'une de celles-ci possède une inscription.\n"
							+ "L'inscription mentionne Cliff.");
		else
			throw new RoomNotAccessibleException("Il fait noir");
	}

	public Room west() throws RoomNotAccessibleException {
		if (utiliserLampe){
			veutTomber = true;
			throw new RoomNotAccessibleException(
					"Vous voyez le puit d'où vous venez, voulez-vous vraiment y retourner ?");
		}
		else
			throw new RoomNotAccessibleException("Il fait noir");
	}

	public Room north() throws RoomNotAccessibleException {
		if (utiliserLampe && !utiliserRoche)
			throw new RoomNotAccessibleException(
					"Vous apercevez quelques planches pourries qui semblent assez faible.");
		else if (utiliserLampe && utiliserRoche)
			return LevelManager.getInstance().getCurrentLevel()
					.getRoom("Enigme");
		else
			throw new RoomNotAccessibleException("Il fait noir");
	}

	@Override
	public void initialiser() {
		utiliserLampe = false;
		pritRoche = false;
		utiliserRoche = false;
		veutTomber = false;		
	}
}
