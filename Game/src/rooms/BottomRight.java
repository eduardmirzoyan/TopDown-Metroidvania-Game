package rooms;

import java.awt.Point;
import game.*;


public class BottomRight extends Room {

	public static Point entrance2 = new Point(8, 0);
	
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
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W"},
			{"W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W"},
			{"W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "*", "*", "*", "*", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
	
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
