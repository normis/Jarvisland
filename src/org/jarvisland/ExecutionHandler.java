package org.jarvisland;

import java.io.ByteArrayOutputStream;

/**
 * Définie une interface pour gérer les commandes
 * d'executions dans Jarvisland
 * 
 * @author niclupien
 *
 */
public interface ExecutionHandler {
	public void execute(String commande, ByteArrayOutputStream outputStream);
}
