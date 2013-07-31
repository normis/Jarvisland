package org.jarvisland;

import org.jarvisland.levels.room.RoomNotAccessibleException;

/**
 * Jarvisland est un jeu RGP en ligne de commande
 * fortement inspiré de Zork I: The Great Underground Empire
 * 
 * Pour démarrer le jeu, il suffit d'appeler le constructeur de
 * JarvislandEngine.
 * 
 * Le jeu utilise la console (System.out et System.in) pour effectuer
 * ses entrés/sorties.
 *  
 * @author niclupien
 *
 */
public class Jarvisland {

	/**
	 * Démarre un nouveau jeu
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new JarvislandEngine();
		} catch (RoomNotAccessibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
