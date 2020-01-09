package rooms;

import java.awt.Point;
import game.*;
import processing.core.PImage;

public class MiddleMiddle extends Room {

	public static Point entrance1 = new Point(0, 9);
	public static Point entrance2 = new Point(7, 0);
	public static Point entrance3 = new Point(17, 9);
	public static Point entrance4 = new Point(8, 17);
	
	private Key yellowKey = new Key("Yellow");
	private Key blueKey = new Key("Blue");
	
	public MiddleMiddle() {
		
	}
	

	public MiddleMiddle(PImage img, PImage img2) {
		yellowKey.setSprite(img);
		blueKey.setSprite(img2);
	}
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "&", "*", "*", "*", "*", "*", "*", "#", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"}, 
			{"E", "*", "*", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "E"},
			{"W", "*", "W", "W", "W", "W", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "*", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "@", "*", "W"},
			{"W", "*", "*", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "W", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "@", "*", "W"},
			{"W", "X", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
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
	
	public Key getKey(int x, int y) {
		System.out.println(x);
		System.out.println(y);
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
