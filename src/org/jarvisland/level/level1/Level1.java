package org.jarvisland.level.level1;

import org.jarvisland.InventoryManager;
import org.jarvisland.level.AbstractLevel;
import org.jarvisland.level.LevelEndedException;
import org.jarvisland.levels.room.Room;
import org.jarvisland.player.DeathException;

public class Level1 extends AbstractLevel {
	boolean outOfPuit = false;
	boolean outOfSurplomb = false;
	boolean outOfEnigme = false;
	boolean outOfWine = false; // that's sad

	private final String messageFinLevel = "Vous grimper une echelle et vous atteigner enfin l'exterieur! La roche engraver par les runes \" cliff \" se met a parler \n "
			+ "-Cliff: Vous devez allez sauve la princesse Jarvis!";

	public Level1() {
		map.put("Puit", new Puit());
		map.put("Surplomb", new Surplomb());
		map.put("Enigme", new Enigme());
		initialiserLevel();
	}

	@Override
	public String execute(String s) {
		String retour = super.execute(s);
		if (retour == null) {
			if (s.matches("(UTILISER|BOIRE).* BOUTEILLE DE VIN") && !outOfWine) {
				InventoryManager.getInstance().removeItem("Bouteille de vin");
				outOfWine = true;
				return "Vous ne vous senter pas bien et vous vous assoyer quelque seconde, vous retoruner la bouteille et \n "
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
		else if (event.equals("estMort")){
			System.out.println("Vous tomber dans le puit, Vous frapper violament le sol apres 10 seconde,\n"
					+ "le sol est couvers de pieux qui vous empale,\n"
					+ "Des bruleurs s'active,\n "
					+ "et les murs commence a bouger pour ecraser se qui reste. \n"
					+ "Bref, vous etes mort applatit, transperé par plusieurs broches, incinéré et ecrabouillé");
			throw new DeathException();
		}
	}

	@Override
	public String getName() {
		return "Niveau 1 - La chute";// u r falling down
	}

	@Override
	public void initialiserLevel() {
		super.initialiserLevel();

		outOfPuit = false;
		outOfSurplomb = false;
		outOfEnigme = false;
		outOfWine = false;
	}

	@Override
	public Room getInitialRoom() {
		return map.get("Puit");
	}
}
