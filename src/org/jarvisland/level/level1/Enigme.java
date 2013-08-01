package org.jarvisland.level.level1;

import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

public class Enigme extends AbstractRoom {

	boolean reusit = false;

	@Override
	public String look() {

		return "Vous êtes dans une chambre qui semble assez vieille. \n "
				+ "Il y a une porte est verrouillée et il y a une roulette à chiffre au dessus de la poigne, \n "
				+ " il y a une instruction sur la porte. \n"
				+ "\"0 0 1 0 1 0 1 0 \" ";
	}

	@Override
	public String execute(String s) {
		if (s.matches("42")) {
			reusit = true;
			return "Vous entendez un son sourd provenant de la porte et elle s'ouvre. Vous entendez une voix murmurée: \" So long, and thanks for all the fish.\"";
		}
		return null;
	}

	@Override
	public Room north() throws RoomNotAccessibleException {
		if (reusit){
			LevelManager.getInstance().notifyCurrentLevel("outOfEnigme");
			return LevelManager.getInstance().getCurrentLevel().getRoom("Enigme");
		}
		else
			throw new RoomNotAccessibleException("La porte est verrouiller.");
	}

	@Override
	public Room south() throws RoomNotAccessibleException {
		return LevelManager.getInstance().getCurrentLevel().getRoom("Surplomb");
	}

	@Override
	public Room east() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException(
				"Il y a une peinture d'une petite machine blanche à l'allure cylindrique qui tient sur deux roues, /n "
						+ "qui est accompagnée d'un être humanoïde doré.");
	}

	@Override
	public Room west() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException(
				"Il y un message ecrit sur le mur avec se qui semble etre du sang vous liser, Douglas Adams");
	}

	@Override
	public void initialiser() {
		reusit = false;		
	}
}
