package rooms;

import java.awt.Point;
import game.*;

public class MiddleMiddle extends Room {

	public static Point entrance1 = new Point(0, 9);
	public static Point entrance2 = new Point(7, 0);
	public static Point entrance3 = new Point(17, 9);
	public static Point entrance4 = new Point(8, 17);
	
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
			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
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
	
	public String[][] getRoom(){
		return map;
	}

	public int getCode() {
		return 5;
	}
}
