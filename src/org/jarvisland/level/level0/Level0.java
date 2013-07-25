package org.jarvisland.level.level0;

import org.jarvisland.level.AbstractLevel;
import org.jarvisland.level.LevelEndedException;

/**
 * Le level 0 est un petit niveau tutoriel qui ne poss�de
 * qu'une seule pi�ce avec un seul objectif : en sortir. 
 * 
 * @author niclupien
 *
 */
public class Level0 extends AbstractLevel {

	boolean isOutOfFirstRoom = false;
	
	public Level0() {
		super(new TutorialRoom());
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
