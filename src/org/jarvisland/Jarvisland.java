package org.jarvisland;

/**
 * Jarvisland est un jeu RGP en ligne de commande
 * fortement inspir� de Zork I: The Great Underground Empire
 * 
 * Pour d�marrer le jeu, il suffit d'appeler le constructeur de
 * JarvislandEngine.
 * 
 * Le jeu utilise la console (System.out et System.in) pour effectuer
 * ses entr�s/sorties.
 *  
 * @author niclupien
 *
 */
public class Jarvisland {

	/**
	 * D�marre un nouveau jeu
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new JarvislandEngine();
	}

}
