package rooms;

import java.awt.Point;
import game.*;
import processing.core.PImage;

public class MiddleMiddle extends Room {

	public static Point entrance1 = new Point(0, 9);
	public static Point entrance2 = new Point(7, 0);
	public static Point entrance3 = new Point(17, 9);
	public static Point entrance4 = new Point(8, 17);
	
	private Key yellowKey, blueKey;
	private Door blueDoor, yellowDoor;
	
	public MiddleMiddle() {
		
	}
	

	public MiddleMiddle(PImage yKey, PImage bKey, PImage yDoor, PImage bDoor) {
		yellowKey = new Key("Yellow", yKey);
		blueKey = new Key("Blue", bKey);
		yellowDoor = new Door("Yellow", yDoor);
		blueDoor = new Door("Blue", bDoor);
	}
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "*", "&", "*", "W", "*", "W", "W", "W", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "*", "W", "*", "W", "*", "*", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "*", "W", "*", "W", "*", "*", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "&", "*", "*", "W", "*", "W", "W", "*", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "*", "W", "*", "*", "*", "*", "W", "*", "#", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "W"}, 
			{"E", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "E"},
			{"W", "*", "W", "W", "W", "W", "W", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "W", "*", "W", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "W", "*", "W", "*", "*", "W", "W", "*", "*", "*", "*", "@", "*", "W"},
			{"W", "*", "*", "*", "W", "*", "W", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "W", "W", "*", "W", "*", "*", "W", "W", "*", "*", "*", "*", "@", "*", "W"},
			{"W", "X", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
	
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
		if(x == 9 && y == 2) {
			return yellowDoor;
		}
		if(x == 6 && y == 5) {
			return blueDoor;
		}
		else {
			return null;
		}
	}
	
	public Key getKey(int x, int y) {
		if(x == 15 && y == 13) {
			return yellowKey;
		}
		if(x == 15 && y == 15) {
			return blueKey;
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
