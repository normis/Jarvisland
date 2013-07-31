package org.jarvisland.level.level1;

import org.jarvisland.level.AbstractLevel;
import org.jarvisland.levels.room.Room;

public class Level1 extends AbstractLevel {

	public Level1() {
		map.put("someRule", new SomeRoom());
		room = map.get("someRule");
	}

	@Override
	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void notify(String event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "The Limbo";
	}

	@Override
	public Room getRoom(String room){
		return map.get(room);
		
	}
}
