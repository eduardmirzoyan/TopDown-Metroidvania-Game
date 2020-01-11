package rooms;

import java.awt.Point;
import game.*;

public class TopLeft extends Room {

	public static Point entrance4 = new Point(8, 17);
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "W", "W", "*", "*", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "W", "W", "*", "*", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "W", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "W", "*", "*", "W", "W", "*", "*", "W", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "E", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};

	public Point changeRoom(Point p, Game g) {
		if(p.equals(entrance4)) {
			g.setCurrentRoom(g.getMiddleLeft());
			return MiddleMiddle.entrance2;
		} else {
			System.out.println("Wrong choice");
		}
		return null;
	}

	public String[][] getRoom() {
		return map;
	}

	public int getCode() {
		return 1;
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
