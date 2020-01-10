package rooms;

import java.awt.Point;
import game.*;

public class MiddleRight extends Room {

	public static Point entrance1 = new Point(0, 8);
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"E", "*", "*", "*", "*", "W", "*", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "W", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};

	
	public Point changeRoom(Point p, Game g) {
		if(p.equals(entrance1)) {
			g.setCurrentRoom(g.getMiddleMiddle());
			return MiddleMiddle.entrance3;
		} else {
			System.out.println("Wrong choice");
			return null;
		}
	}

	public String[][] getRoom() {
		return map;
	}

	public int getCode() {
		return 6;
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
