package org.jarvisland.level;

import java.io.ByteArrayOutputStream;

import org.jarvisland.ExecutionHandler;
import org.jarvisland.levels.room.Room;
import org.jarvisland.levels.room.RoomNotAccessibleException;

/**
 * Level - Regroupement de pièces (Room) qui forme une map.
 * 
 * Le niveau fait le lien entre les entrées traitées par JarvislandEngine
 * et pièces d'un niveau du jeu.
 * 
 * Un niveau contient des objectifs déclancher par des actions du joueur
 * dans des pièces.
 * 
 * Lorsque tous les objectifs sont terminés, on peut changer de niveau
 * 
 * @author niclupien
 *
 */
public interface Level extends ExecutionHandler {
	/**
	 * Définit si le niveau est terminé
	 * @return isCompleted
	 */
	public boolean isCompleted();
	
	/**
	 * Déplacement dans une direction donnée
	 * 
	 * @param direction
	 * @return 
	 * @throws RoomNotAccessibleException
	 */
	public String navigate(String direction);
	
	/**
	 * Traitement d'une commande
	 * 
	 * @param commande
	 * @return résultat
	 */
	@Override
	public void execute(String commande, ByteArrayOutputStream baos);
	
	/**
	 * Description de la pièce
	 * 
	 * @return description
	 */
	public String look();
	
	/**
	 * Traitement d'événement qui se passe dans le niveau comme
	 * par exemple, le déclanchement de la complétion d'un objectif.
	 * 
	 * @param event
	 */
	public void notify(String event);
	
	/**
	 * Nom du niveau
	 * 
	 * @return nom
	 */
	public String getName();
	
	/**
	 * 
	 * @param newRoom
	 * @return
	 */
	public String changeRoom(String newRoom);
	
	/**
	 * Nom de la room actuel
	 * 
	 * @return nom
	 */
	public Room getRoom(String room);	
	
	/**
	 * Initialisation de la room
	 * 
	 * @return nom
	 */
	public void initialiserLevel();
	
	public Room getInitialRoom();
	
	
}
