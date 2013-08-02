package org.jarvisland.level.level2;

import org.jarvisland.CombatManager;
import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractMonsterRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;
import org.jarvisland.userBase.AtomMonsterFactory;
import org.jarvisland.userBase.MonsterFactory;

public class HallRoom extends AbstractMonsterRoom implements Room {

	@Override
	public String look() {
		if (!monster.isDead()) {
			CombatManager cm = new CombatManager(monster);
			cm.DemarrerCombat();
		}
			
		return "Vous êtes dans le hall.";
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

	@Override
	public MonsterFactory getMonsterFactory() {
		return new AtomMonsterFactory();
	}

}
