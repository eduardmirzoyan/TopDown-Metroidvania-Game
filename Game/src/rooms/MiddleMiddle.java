package rooms;

import java.awt.Point;
import game.*;
import processing.core.PImage;

public class MiddleMiddle extends Room {

	public static Point entrance1 = new Point(0, 9);
	public static Point entrance2 = new Point(7, 0);
	public static Point entrance3 = new Point(17, 9);
	public static Point entrance4 = new Point(8, 17);
	
	private Key yellowKey, skyKey, pinkKey, brownKey;
	private Door greenDoor, yellowDoor, redDoor, blueDoor, blackDoor;
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "*", "W", "*", "&", "*", "W", "#", "*", "W"},
			{"W", "*", "*", "@", "*", "*", "W", "*", "&", "*", "W", "*", "W", "*", "W", "W", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "&", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "W"},
			{"W", "*", "*", "@", "*", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "*", "&", "*", "W", "*", "&", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}, 
			{"E", "*", "*", "*", "*", "*", "*", "@", "*", "*", "*", "*", "*", "*", "*", "*", "*", "E"},
			{"W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "@", "*", "*", "W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "*", "*", "W", "*", "*", "*", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "*", "W"},
			{"W", "X", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
	
	public MiddleMiddle(PImage yKey, PImage sKey, PImage pKey, PImage bKey, PImage yDoor, PImage bDoor, PImage rDoor, PImage gDoor, PImage blDoor) {
		yellowKey = new Key("Yellow", yKey);
		skyKey = new Key("Sky", sKey);
		pinkKey = new Key("Pink", pKey);
		brownKey = new Key("Brown", bKey);
		
		yellowDoor = new Door("Yellow", yDoor);
		blueDoor = new Door("Blue", bDoor);
		redDoor = new Door("Red", rDoor);
		greenDoor = new Door("Green", gDoor);
		blackDoor = new Door("Dark Skinned", blDoor);
	}
	
	public Point changeRoom(Point p, Game g) {
		if(p.equals(entrance1)) {
			g.setCurrentRoom(g.getMiddleLeft());
			return MiddleLeft.entrance3;
			
		} else if (p.equals(entrance3)) { 
			g.setCurrentRoom(g.getMiddleRight());
			return MiddleRight.entrance1;
			
		} else if (p.equals(entrance2)) { 
			g.setCurrentRoom(g.getTopMiddle());
			return TopMiddle.entrance4;
			
		} else if (p.equals(entrance4)) { 
			g.setCurrentRoom(g.getBottomMiddle());
			return BottomMiddle.entrance2;
			
		}
		System.out.println("Wrong choice");
		return null;

	}
	
	public Door getDoor(int x, int y) {
		if(x == 8 && y == 2) {
			return yellowDoor;
		}
		if(x == 10 && y == 7) {
			return redDoor;
		}
		if(x == 12 && y == 1) {
			return blueDoor;
		}
		if(x == 14 && y == 7) {
			return blackDoor;
		}
		if(x == 6 && y == 5) {
			return greenDoor;
		}
		else {
			return null;
		}
	}
	
	public Key getKey(int x, int y) {
		if(x == 3 && y == 2) {
			return yellowKey;
		}
		if(x == 3 && y == 6) {
			return skyKey;
		}
		if(x == 3 && y == 12) {
			return pinkKey;
		}
		if(x == 7 && y == 9) {
			return brownKey;
		}
		else {
			return null;
		}
	}
	
	public String[][] getRoom(){
		return map;
	}

	public int getCode() {
		return 5;
	}
}
