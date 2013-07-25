package org.jarvisland.level;

import org.jarvisland.levels.room.RoomNotAccessibleException;

/**
 * Level - Regroupement de pi�ces (Room) qui forme une map.
 * 
 * Le niveau fait le lien entre les entr�es trait�es par JarvislandEngine
 * et pi�ces d'un niveau du jeu.
 * 
 * Un niveau contient des objectifs d�clancher par des actions du joueur
 * dans des pi�ces.
 * 
 * Lorsque tous les objectifs sont termin�s, on peut changer de niveau
 * 
 * @author niclupien
 *
 */
public interface Level {
	/**
	 * D�finit si le niveau est termin�
	 * @return isCompleted
	 */
	public boolean isCompleted();
	
	/**
	 * D�placement dans une direction donn�e
	 * 
	 * @param direction
	 * @throws RoomNotAccessibleException
	 */
	public void navigate(String direction) throws RoomNotAccessibleException;
	
	/**
	 * Traitement d'une commande
	 * 
	 * @param commande
	 * @return r�sultat
	 */
	public String execute(String commande);
	
	/**
	 * Description de la pi�ce
	 * 
	 * @return description
	 */
	public String look();
	
	/**
	 * Traitement d'�v�nement qui se passe dans le niveau comme
	 * par exemple, le d�clanchement de la compl�tion d'un objectif.
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
}
