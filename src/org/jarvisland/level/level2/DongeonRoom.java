package org.jarvisland.level.level2;

import org.jarvisland.CombatManager;
import org.jarvisland.LevelManager;
import org.jarvisland.level.LevelEndedException;
import org.jarvisland.levels.room.AbstractMonsterRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;
import org.jarvisland.lifeform.MonsterFactory;
import org.jarvisland.lifeform.NachosMonsterFactory;

public class DongeonRoom extends AbstractMonsterRoom implements Room {

	@Override
	public String look() {
		if (!monster.isDead()) {
			CombatManager cm = new CombatManager(monster);
			cm.demarrerCombat();
		}
		
		System.out.println();
		System.out.println("Vous avez sauvé la princesse Jarvis.");
		System.out.println("Fin!");
		
		throw new LevelEndedException();
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
		return LevelManager.getInstance().getCurrentLevel().getRoom("trone");
	}
	
	@Override
	public MonsterFactory getMonsterFactory() {
		return new NachosMonsterFactory();
	}
}
