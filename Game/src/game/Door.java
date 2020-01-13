package game;

import processing.core.PApplet;
import processing.core.PImage;

public class Door {
	
	String color;
	PImage sprite;
	
	public Door(String col) {
		color = col;
	}
	
	public Door(String col, PImage img) {
		color = col;
		sprite = img;
	}
	/**
	 * 
	 * @param i Sets door sprite to input
	 */
	public void setSprite(PImage i) {
		sprite = i;
	}
	
	/**
	 * 
	 * @param i Sets door color to input string
	 */
	public void setColor(String i) {
		color = i;
	}
	
	/**
	 * 
	 * @return Returns the color of the door
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * 
	 * @param p The PApplet used to draw the inventory elements
	 * @param x The topleft x cord of the inventory module
	 * @param y The topleft y cord of the inventory module
	 * @param size
	 */
	public void draw(PApplet p, int x, int y, int size) {
		p.pushMatrix();
		
		p.image(sprite, x, y, size, size);
		
		p.popMatrix();
	}
	
	/**
	 * Checks to see if the player's inventory has a key that can open this door
	 * @param inv The inventory used to check if a key exists
	 * @return True or false depending if a key exists that matches this door's color
	 */
	public boolean unlock(Inventory inv) {
		if(inv.removeKey(color)) {
			return true;
		}
		else {
			return false;
		}
	}
}
