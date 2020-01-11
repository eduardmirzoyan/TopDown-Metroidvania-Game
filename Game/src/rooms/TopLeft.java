package rooms;

import java.awt.Point;
import game.*;
import processing.core.PImage;

public class TopLeft extends Room {

	public static Point entrance4 = new Point(8, 17);
	
	private Key redKey, purpleKey;
	private Door grayDoor, pinkDoor;
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "&", "*", "*", "@", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "W", "W", "*", "*", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "&", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "@", "*", "*", "W", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "W", "W", "*", "*", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
	
	
	public TopLeft(PImage rKey, PImage pKey, PImage gDoor, PImage pDoor) {
		redKey = new Key("Red", rKey);
		purpleKey = new Key("Purple", pKey);
		
		grayDoor = new Door("Gray", gDoor);
		pinkDoor = new Door("Pink", pDoor);
	}

	public Point changeRoom(Point p, Game g) {
		if(p.equals(entrance4)) {
			g.setCurrentRoom(g.getMiddleLeft());
			return MiddleMiddle.entrance2;
		}
		return null;
	}

	public String[][] getRoom() {
		return map;
	}

	public int getCode() {
		return 1;
	}

	public Key getKey(int x, int y) {
		if(x == 2 && y == 8) {
			return redKey;
		}
		if(x == 15 && y == 2) {
			return purpleKey;
		}
		return null;
	}

	public Door getDoor(int x, int y) {
		if(x == 5 && y == 7) {
			return grayDoor;
		}
		if(x == 12 && y == 2) {
			return pinkDoor;
		}
		return null;
	}
}
