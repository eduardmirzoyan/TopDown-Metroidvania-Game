package rooms;

import java.awt.Point;
import game.*;

public abstract class Room {

	private String[][] map;
	
	public abstract Point changeRoom(Point p, Game g);
	
	public abstract String[][] getRoom();
	
	public abstract Key getKey(int x, int y);
	
	public abstract Door getDoor(int x, int y);
	
	public abstract int getCode();
}
