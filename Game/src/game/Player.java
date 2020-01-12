package game;

import java.awt.Point;

import processing.core.PApplet;
import processing.core.PImage;

public class Player {

	private Point location;
	private Inventory inventory;
	private PImage sprite;
	
	public Player(int x, int y, PImage img) {
		sprite = img;
		location = new Point(x, y);
		inventory = new Inventory();
	}
	
	public void relocate(int x, int y) {
		location = new Point(x, y);
	}
	
	public double getX() {
		return location.getX();
	}
	
	public double getY() {
		return location.getY();
	}
	
	public void setImage(PImage img) {
		sprite = img;
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
	
	public void draw(PApplet p, int x, int y, int size) {
		p.pushMatrix();
		p.image(sprite, x, y, size, size);
		p.popMatrix();
	}
}
