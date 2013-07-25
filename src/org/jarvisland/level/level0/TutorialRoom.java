package org.jarvisland.level.level0;

import org.jarvisland.InventoryManager;
import org.jarvisland.LevelManager;
import org.jarvisland.levels.room.AbstractRoom;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;


/**
 * La pi�ce tutoriel du niveau 0
 * 
 * Il faut ouvrir un coffre, prendre la cl�, utiliser la cl�
 * sur la porte et sortir de la pi�ce. 
 * 
 * @author niclupien
 *
 */
public class TutorialRoom extends AbstractRoom {
	boolean coffreOuvert = false;
	boolean isPorteOuverte = false;
	
	public String execute(String s) {
		if (s.matches("OUVRIR.* COFFRE")) {
			if (coffreOuvert)
				return "Le coffre est d�j� ouvert.";
			
			coffreOuvert = true;
			return "Le coffre s'ouvre et un �pais nuage de poussi�re en sort. Il y a une cl� dans le fond.";
		} else if (s.matches("PRENDRE.* CL�")) {
			if (coffreOuvert && !InventoryManager.getInstance().hasItem("Cl�")) {
				InventoryManager.getInstance().addItem("Cl�");
				return "Vous ramassez une cl�.";
			}
		} else if (s.matches("UTILISER.* CL�.* PORTE")) {
			if (InventoryManager.getInstance().hasItem("Cl�")) {
				isPorteOuverte = true;
				InventoryManager.getInstance().removeItem("Cl�");
				return "La porte est maintenant ouverte.";
			}
		}
		
		return null;
	}

	public String look() {
		return "Vous vous trouvez dans une petite pi�ce sombre.\n" +
				"Vous n'avez aucune id�e o� vous �tes mais vous voyez\n" +
				"un coffre dans un coin � c�t� d'ossements humains.";
	}
	

	public Room north() throws RoomNotAccessibleException {
		if (!isPorteOuverte)
			throw new RoomNotAccessibleException("Vous voyez une porte m�tallique.\nElle est verrouill�e et il n'y a aucun moyen de la d�fon�er.");
		LevelManager.getInstance().notifyCurrentLevel("outOfFirstRoomEvent");
		return null;
	}
	
	public Room south() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException("Vous voyez un mur de pierre couvert de taches de sang.");
	}
	
	public Room east() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException("Vous voyez un mur de pierre.");
	}
	
	public Room west() throws RoomNotAccessibleException {
		throw new RoomNotAccessibleException("Vous voyez un mur de pierre.");
	}
}
