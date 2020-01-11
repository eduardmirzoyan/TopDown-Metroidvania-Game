package rooms;

import java.awt.Point;
import game.*;
import processing.core.PImage;


public class BottomRight extends Room {

	public static Point entrance2 = new Point(8, 0);
	
	private Key blackKey;
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W"},
			{"W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W"},
			{"W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "@", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W"},
			{"W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W"},
			{"W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
	
	public BottomRight(PImage bKey) {
		blackKey = new Key("Black", bKey);
	}
	
	public Point changeRoom(Point p, Game g) {
		if(p.equals(entrance2)) {
			g.setCurrentRoom(g.getBottomMiddle());
			return BottomMiddle.entrance4;
		}
		return null;
	}

	public String[][] getRoom() {
		return map;
	}

	public int getCode() {
		return 9;
	}

	public Key getKey(int x, int y) {
		if(x == 9 && y == 9) {
			return blackKey;
		}
		return null;
	}

	public Door getDoor(int x, int y) {
		return null;
	}

}
