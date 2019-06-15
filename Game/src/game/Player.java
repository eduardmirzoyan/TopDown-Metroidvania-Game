package game;

import java.awt.Point;

public class Player {

	Point location;
	private boolean hasKey;
	
	public Player(int x, int y) {
		location = new Point(x, y);
	}
	
	public void relocate(int x, int y) {
		location = new Point(x, y);
	}
	
	public boolean hasKey() {
		return hasKey;
	}
	
	public double getX() {
		return location.getX();
	}
	
	public double getY() {
		return location.getY();
	}
	
	public Point getLocation() {
		return location;
	}
}
