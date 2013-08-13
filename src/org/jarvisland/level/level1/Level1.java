package org.jarvisland.level.level1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

	private final String messageFinLevel = "Vous grimpez une échelle et vous atteignez enfin l'extérieur! La roche engravée par les ruines \" cliff \" se met à parler \n "
			+ "-Cliff: Vous devez aller sauver la princesse Jarvis!";

	public Level1() {
		map.put("Puit", new Puit());
		map.put("Surplomb", new Surplomb());
		map.put("Enigme", new Enigme());
		initialiserLevel();
	}

	@Override
	public void execute(String s, ByteArrayOutputStream baos) {
		super.execute(s, baos);
		PrintStream ps = new PrintStream(baos);
		if (s.matches("(UTILISER|BOIRE).* BOUTEILLE DE VIN") && !outOfWine) {
			InventoryManager.getInstance().removeItem("Bouteille de vin");
			outOfWine = true;
			ps.println("Vous ne vous sentez pas bien et vous " +
					"vous assoyez quelques secondes, vous retournez la " +
					"bouteille et \n apercevez une tête de mort imprimée " +
					"sur la bouteille.");
		}
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
		} else if (event.equals("estMort")) {
			System.out
					.println("Vous tombez dans le puit, Vous frappez violemment le sol après 10 secondes,\n"
							+ "le sol est couvert de pieux qui vous empalent,\n"
							+ "Des brûleurs s'activent,\n "
							+ "et les murs commencent à bouger pour écraser ce qui vous reste. \n"
							+ "Bref, vous êtes mort aplatit, transpercé par plusieurs broches, incinéré et écrabouillé");
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
