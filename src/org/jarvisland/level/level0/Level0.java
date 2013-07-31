package org.jarvisland.level.level0;

import org.jarvisland.level.AbstractLevel;
import org.jarvisland.level.LevelEndedException;
import org.jarvisland.levels.room.Room;

/**
 * Le level 0 est un petit niveau tutoriel qui ne possède
 * qu'une seule pièce avec un seul objectif : en sortir. 
 * 
 * @author niclupien
 *
 */
public class Level0 extends AbstractLevel {

	boolean isOutOfFirstRoom = false;
	
	
	public Level0() {
		map.put("tutorial", new TutorialRoom());
		room = map.get("tutorial");
		
	}
	
	public Room getRoom(String room){
		return map.get(room);
		
	}
	
	@Override
	public boolean isCompleted() {
		return isOutOfFirstRoom;
	}

	@Override
	public void notify(String event) {
		if (event.equals("outOfFirstRoomEvent")) {
			isOutOfFirstRoom = true;
			throw new LevelEndedException();
		}
	}

	@Override
	public String getName() {
		return "Le commencement";
	}

}
