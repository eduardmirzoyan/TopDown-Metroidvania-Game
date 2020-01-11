package rooms;

import java.awt.Point;
import game.*;
import processing.core.PImage;

public class TopMiddle extends Room {

	public static Point entrance3 = new Point(17, 8);
	public static Point entrance4 = new Point(8, 17);
	
	private Door skyDoor;
	private Key grayKey, orangeKey;
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "&", "W"},
			{"W", "*", "W", "W", "W", "*", "*", "*", "*", "@", "*", "*", "*", "W", "W", "W", "*", "W"},
			{"W", "*", "*", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "W", "W", "*", "*", "*", "*", "W", "W", "W", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "W", "W", "*", "*", "W", "W", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "E"},
			{"W", "*", "@", "*", "*", "*", "*", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "W", "W", "*", "*", "W", "W", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "W", "W", "*", "*", "*", "*", "W", "W", "W", "*", "*", "*", "W"},
			{"W", "*", "*", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "*", "*", "W"},
			{"W", "*", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "*", "W"},
			{"W", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "W"},
			{"W", "*", "&", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
	
	public TopMiddle(PImage gKey, PImage oKey, PImage sDoor) {
		orangeKey = new Key("Orange", oKey);
		grayKey = new Key("Gray", gKey);
		
		skyDoor = new Door("Sky", sDoor);
	}

	public Point changeRoom(Point p, Game g) {
		if(p.equals(entrance4)) {
			g.setCurrentRoom(g.getMiddleMiddle());
			return MiddleMiddle.entrance2;
		} else if(p.equals(entrance3)) {
			g.setCurrentRoom(g.getTopRight());
			return TopRight.entrance1;
		}
		System.out.println("Wrong choice");
		return null;
	}

	public String[][] getRoom() {
		return map;
	}

	public int getCode() {
		return 2;
	}

	public Key getKey(int x, int y) {
		if(x == 2 && y == 9) {
			return grayKey;
		}
		if(x == 9 && y == 3) {
			return orangeKey;
		}
		return null;
	}

	public Door getDoor(int x, int y) {
		if((x == 2 && y == 16) || (x == 16 && y == 2)) {
			return skyDoor;
		}
		return null;
	}
}
