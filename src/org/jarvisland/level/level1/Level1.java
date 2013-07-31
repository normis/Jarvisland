package org.jarvisland.level.level1;

import org.jarvisland.InventoryManager;
import org.jarvisland.level.AbstractLevel;
import org.jarvisland.level.LevelEndedException;
import org.jarvisland.levels.room.Room;

public class Level1 extends AbstractLevel {
	boolean outOfPuit = false;
	boolean outOfSurplomb = false;
	boolean outOfEnigme = false;
	boolean outOfWine = false; // that's sad
	boolean estMort = false;

	String messageFinLevel = "Vous grimper une echelle et vous atteigner enfin l'exterieur! La roche engraver par les runes \" cliff \" se met a parler \n "
			+ "-Cliff: Vous devez allez sauve la princesse Jarvis!";

	public Level1() {
		map.put("Puit", new Puit());
		map.put("Surplomb", new Surplomb());
		map.put("Enigme", new Enigme());
		room = map.get("Puit");
		InventoryManager.getInstance().addItem("Bouteille de vin");
		InventoryManager.getInstance().addItem("Lampe de poche");
		InventoryManager.getInstance().addItem("Grappin");
	}

	@Override
	public String execute(String s) {
		String retour = super.execute(s);
		if (retour == null) {
			if (s.matches("(UTILISER|BOIRE).* BOUTEILLE DE VIN") && !outOfWine) {
				InventoryManager.getInstance().removeItem("Bouteille de vin");
				outOfWine = true;
				return "Vous ne vous senter pas bien et vous vous assoyer quel que seconde, vous retoruner la bouteille et \n "
						+ "apercever une tete de mort imprimer sur la bouteile.";
			}
		}
		return retour;
	}

	@Override
	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return outOfPuit && outOfSurplomb && outOfEnigme;
	}

	@Override
	public void notify(String event) {
		if (event.equals("outOfPuit"))
			outOfPuit = true;
		else if (event.equals("outOfSurplomb"))
			outOfSurplomb = true;
		else if (event.equals("outOfEnigme")) {
			outOfEnigme = true;
			System.out.println(messageFinLevel);
			throw new LevelEndedException();
		}
		// else if (event.equals("estMort"))
		//throw new DeathException();
	}

	@Override
	public String getName() {
		return "Niveau Un";// u r falling down
	}
}
