package rooms;

import java.awt.Point;
import game.*;
import processing.core.PImage;

public class MiddleRight extends Room {

	public static Point entrance1 = new Point(0, 8);
	public static Point entrance2 = new Point(14, 0);
	
	private Key neonKey, blueKey, whiteKey;
	private Door brownDoor, orangeDoor;
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "W", "*", "*", "@", "*", "*", "*", "@", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "W", "W", "W", "*", "*", "*", "W", "*", "*", "*", "W", "*", "*", "*", "W"},
			{"E", "*", "*", "*", "*", "W", "*", "@", "*", "W", "*", "*", "*", "W", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "W", "*", "*", "*", "W", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "W", "*", "*", "*", "W", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "&", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "*", "W", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "&", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};

	public MiddleRight(PImage nKey, PImage bKey, PImage wKey, PImage bDoor, PImage oDoor) {
		neonKey = new Key("Neon", nKey);
		blueKey = new Key("Blue", bKey);
		whiteKey = new Key("White", wKey);
		
		brownDoor = new Door("Brown", bDoor);
		orangeDoor = new Door("Orange", oDoor);
	}
	
	public Point changeRoom(Point p, Game g) {
		if(p.equals(entrance1)) {
			g.setCurrentRoom(g.getMiddleMiddle());
			return MiddleMiddle.entrance3;
		} 
		if(p.equals(entrance2)) {
			g.setCurrentRoom(g.getTopRight());
			return TopRight.entrance4;
		} 
		return null;
	}

	public String[][] getRoom() {
		return map;
	}

	public int getCode() {
		return 6;
	}

	public Key getKey(int x, int y) {
		if(x == 7 && y == 8) {
			return neonKey;
		}
		if(x == 10 && y == 4) {
			return blueKey;
		}
		if(x == 14 && y == 4) {
			return whiteKey;
		}
		return null;
	}

	public Door getDoor(int x, int y) {
		if(x == 9 && y == 11) {
			return brownDoor;
		}
		if(x == 5 && y == 16) {
			return orangeDoor;
		}
		return null;
	}
}
