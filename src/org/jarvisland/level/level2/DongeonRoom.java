package org.jarvisland.level.level2;

import org.jarvisland.CombatManager;
import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractMonsterRoom;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;
import org.jarvisland.userBase.AtomMonsterFactory;
import org.jarvisland.userBase.MonsterFactory;
import org.jarvisland.userBase.NachosMonsterFactory;

public class DongeonRoom extends AbstractMonsterRoom implements Room {

	@Override
	public String look() {
		if (!monster.isDead()) {
			CombatManager cm = new CombatManager(monster);
			cm.DemarrerCombat();
		}
		return "Vous êtes dans le dongeon";
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
