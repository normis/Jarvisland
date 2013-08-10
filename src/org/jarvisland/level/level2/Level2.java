package org.jarvisland.level.level2;

import org.jarvisland.level.AbstractLevel;
import org.jarvisland.level.LevelEndedException;
import org.jarvisland.levels.room.Room;
import org.jarvisland.player.DeathException;

/**
 * Le level 0 est un petit niveau tutoriel qui ne possède
 * qu'une seule pièce avec un seul objectif : en sortir. 
 * 
 * @author niclupien
 *
 */
public class Level2 extends AbstractLevel {
	
	
	public Level2() {
		map.put("foret", new ForetRoom());
		map.put("chateau", new ChateauRoom());
		map.put("cour", new CourRoom());
		map.put("chambre", new ChambreRoom());
		map.put("cuisine", new CuisineRoom());
		map.put("tour", new TourRoom());
		map.put("hall", new HallRoom());
		map.put("trone", new TroneRoom());
		map.put("dongeon", new DongeonRoom());
		initialiserLevel();
	}
	
	@Override
	public boolean isCompleted() {
		return false;
	}

	@Override
	public void notify(String event) {
		/*if (event.equals("diminuerNbrPas"))
			CountDown.getInstance().decreasePas();*/
	}

	@Override
	public String getName() {
		return "Niveau 2 - Le chateau";
	}

	@Override
	public Room getInitialRoom() {
		return map.get("foret");
	}

	@Override
	public void initialiserLevel() {
		super.initialiserLevel();
	}
}
