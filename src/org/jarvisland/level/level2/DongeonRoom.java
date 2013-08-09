package org.jarvisland.level.level2;

import org.jarvisland.CombatManager;
import org.jarvisland.InventoryManager;
import org.jarvisland.LevelManager;
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
		
		return "Nachos s'écroule par terre en disant d'un dernier soupire ....arh arh.. SegFault Bitch!!!!...\n"
				+ "Vous voyez un objet scintillant apparaître au fond de la pièce qui semble être une clé.";
	}

	@Override
	public String execute(String s) {
		if (s.matches("PRENDRE.* CLE")) {
			InventoryManager.getInstance().addItem("cle tour");
			return "Vous ramasez la clé qui est au fond de la pièce.";
		}
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
