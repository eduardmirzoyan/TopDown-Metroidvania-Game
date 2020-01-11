package rooms;

import java.awt.Point;
import game.*;
import processing.core.PImage;

public class BottomLeft extends Room {

	public static Point entrance2 = new Point(2, 0);
	
	private Key greenKey;
	private Door turkDoor;
	
	private String[][] map = {
			{"W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "M", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "M", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "M", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "M", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "M", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "M", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "*", "W", "W", "W", "W", "W", "W", "M", "M", "M", "M", "M", "M", "*", "M", "W"},
			{"W", "W", "*", "W", "W", "W", "W", "W", "W", "M", "M", "M", "M", "M", "M", "*", "M", "W"},
			{"W", "*", "*", "*", "W", "*", "*", "*", "W", "M", "*", "*", "*", "M", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "M", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "*", "*", "*", "W", "M", "*", "*", "*", "M", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "W", "W", "M", "M", "*", "M", "M", "M", "M", "M", "W"},
			{"W", "*", "*", "*", "W", "*", "*", "*", "W", "M", "*", "*", "*", "M", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "M", "*", "*", "*", "&", "*", "@", "*", "W"},
			{"W", "*", "*", "*", "W", "*", "*", "*", "W", "M", "*", "*", "*", "M", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
 
	public BottomLeft(PImage gKey, PImage tDoor) {
		greenKey = new Key("Green", gKey);
		
		turkDoor = new Door("Turquoise", tDoor);
	}
	
	public Point changeRoom(Point p, Game g) {
		if(p.equals(entrance2)) {
			g.setCurrentRoom(g.getMiddleLeft());
			return MiddleLeft.entrance4;
		}
		return null;
	}

	public String[][] getRoom() {
		return map;
	}

	public int getCode() {
		return 7;
	}

	public Key getKey(int x, int y) {
		if(x == 15 && y == 15) {
			return greenKey;
		}
		return null;
	}

	public Door getDoor(int x, int y) {
		if(x == 13 && y == 15) {
			return turkDoor;
		}
		return null;
	}
	
}
