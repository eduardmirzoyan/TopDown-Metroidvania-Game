package game;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Room {

	private String[][] map;
	
	public abstract Point changeRoom(Point p, Game g);
	
	public abstract String[][] getRoom();
	
}
