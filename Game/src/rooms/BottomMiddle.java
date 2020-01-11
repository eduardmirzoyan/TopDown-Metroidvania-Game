package rooms;

import java.awt.Point;
import game.*;
import processing.core.PImage;


public class BottomMiddle extends Room {

	public static Point entrance2 = new Point(7, 0);
	public static Point entrance4 = new Point(8, 17);
	
	private Door whiteDoor;
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "W", "&", "W", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
	
	public BottomMiddle(PImage wDoor) {
		whiteDoor = new Door("White", wDoor);
	}
	
	public Point changeRoom(Point p, Game g) {
		if(p.equals(entrance2)) {
			g.setCurrentRoom(g.getMiddleMiddle());
			return MiddleMiddle.entrance4;
		} else if(p.equals(entrance4)) {
			g.setCurrentRoom(g.getBottomRight());
			return BottomRight.entrance2;
		}
		return null;
	}


	public String[][] getRoom() {
		return map;
	}

	public int getCode() {
		return 8;
	}


	public Key getKey(int x, int y) {
		return null;
	}

	public Door getDoor(int x, int y) {
		if(x == 8 && y == 16) {
			return whiteDoor;
		}
		return null;
	}

}
