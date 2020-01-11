package rooms;

import java.awt.Point;
import game.*;

public class TopMiddle extends Room {

	public static Point entrance3 = new Point(17, 8);
	public static Point entrance4 = new Point(8, 17);
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "W"},
			{"W", "*", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "*", "W"},
			{"W", "*", "*", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "W", "W", "*", "*", "*", "*", "W", "W", "W", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "W", "W", "*", "*", "W", "W", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "E"},
			{"W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "W", "W", "*", "*", "W", "W", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "W", "W", "*", "*", "*", "*", "W", "W", "W", "*", "*", "*", "W"},
			{"W", "*", "*", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "*", "*", "W"},
			{"W", "*", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "*", "W"},
			{"W", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};

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

	@Override
	public Key getKey(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Door getDoor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}
