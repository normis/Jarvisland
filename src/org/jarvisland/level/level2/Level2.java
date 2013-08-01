package org.jarvisland.level.level2;

import org.jarvisland.level.AbstractLevel;
import org.jarvisland.level.LevelEndedException;

/**
 * Le level 0 est un petit niveau tutoriel qui ne possède
 * qu'une seule pièce avec un seul objectif : en sortir. 
 * 
 * @author niclupien
 *
 */
public class Level2 extends AbstractLevel {

	boolean isOutOfFirstRoom = false;
	
	
	public Level2() {
		map.put("foret", new ForetRoom());
		map.put("chateau", new ChateauRoom());
		map.put("cour", new CourRoom());
		map.put("chambre", new ChambreRoom());
		map.put("cuisine", new CusineRoom());
		map.put("tour", new TourRoom());
		map.put("hall", new HallRoom());
		map.put("trone", new TroneRoom());
		map.put("dongeon", new DongeauRoom());
		room = map.get("foret");
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
