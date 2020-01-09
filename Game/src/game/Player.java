package game;

import java.awt.Point;

public class Player {

	private Point location;
	private Inventory inventory;
	
	private boolean hasKey;
	
	public Player(int x, int y) {
		location = new Point(x, y);
		inventory = new Inventory();
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
	
	public void setLocation(Point p) {
		location = p;
	}
	
	public Point getLocation() {
		return location;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
}
