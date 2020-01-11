package rooms;

import java.awt.Point;
import game.*;
import processing.core.PImage;

public class TopRight extends Room {

	public static Point entrance1 = new Point(0, 8);
	public static Point entrance4 = new Point(14, 17);
	
	private Key turkKey;
	private Door purpleDoor, neonDoor;
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "W", "*", "@", "*", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "W", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "W", "&", "W", "W", "*", "*", "*", "*", "*", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W"},
			{"E", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "W", "W", "W", "W", "W", "*", "*", "*", "*", "W", "*", "*", "W", "&", "W"},
			{"W", "*", "W", "W", "W", "W", "W", "W", "W", "*", "*", "*", "W", "*", "W", "W", "*", "W"},
			{"W", "*", "W", "W", "W", "W", "W", "W", "W", "*", "*", "*", "W", "W", "W", "*", "*", "W"},
			{"W", "*", "*", "W", "W", "W", "W", "W", "*", "*", "*", "*", "W", "W", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W"},
		};
	
	public TopRight(PImage tKey, PImage pDoor, PImage nDoor) {
		turkKey = new Key("Turquoise", tKey);
		
		purpleDoor = new Door("Purple", pDoor);
		neonDoor = new Door("Neon", nDoor);
	}

	public Point changeRoom(Point p, Game g) {
		if(p.equals(entrance1)) {
			g.setCurrentRoom(g.getTopMiddle());
			return TopMiddle.entrance3;
		}
		if(p.equals(entrance4)) {
			g.setCurrentRoom(g.getMiddleRight());
			return MiddleRight.entrance2;
		}
		return null;
	}

	public String[][] getRoom() {
		return map;
	}

	public int getCode() {
		return 3;
	}

	public Key getKey(int x, int y) {
		if(x == 7 && y == 3) {
			return turkKey;
		}
		return null;
	}

	public Door getDoor(int x, int y) {
		if(x == 7 && y == 5) {
			return purpleDoor;
		}
		if(x == 16 && y == 11) {
			return neonDoor;
		}
		return null;
	}
}
