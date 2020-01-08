package rooms;

import java.awt.Point;
import game.*;

public abstract class Room {

	private String[][] map;
	
	public abstract Point changeRoom(Point p, Game g);
	
	public abstract String[][] getRoom();
	
	public abstract int getCode();
}
