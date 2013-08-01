package org.jarvisland.levels.room;

/**
 * 
 * @author niclupien
 *
 */
public interface Room {
	
	public String look();

	public String execute(String s);
	
	public Room north() throws RoomNotAccessibleException;
	public Room south() throws RoomNotAccessibleException;
	public Room east() throws RoomNotAccessibleException;
	public Room west() throws RoomNotAccessibleException;

	public void initialiser();

}
