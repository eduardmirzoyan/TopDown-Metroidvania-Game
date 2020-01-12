package game;

import java.util.ArrayList;

import processing.core.PApplet;

public class Inventory {

	// The common colors used throughout the game
	private final int darkgray = 47, lightgray = 106;
	
	// A list of carried items by the player
	ArrayList<Key> items;
	
	public Inventory() {
		 items = new ArrayList<Key>();
	}
	
	/**
	 * Adds the key to the inventory if it doesn't exceed 4 items
	 * @param item the Key that is wanted to be added
	 * @return true or false depending if key was successfully added
	 */
	public boolean addKey(Key item) {
		if(items.size() > 4) {
			return false;
		}
		items.add(item);
		return true;
	}
	
	/**
	 * Removes key from inventory
	 * @param color the color of the key wanting to be removed
	 * @return true or false depending if key was successfully removed
	 */
	public boolean removeKey(String color) {
		for(int i = 0; i < items.size(); i++) {
			if(color == items.get(i).getColor()) {
				items.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @return The newest key that was added to the inventory
	 */
	public Key getNewest() {
		return items.get(items.size() - 1);
	}
	
	/**
	 * Draws the inventory UI of the player on the game screen along with all carried keys
	 * @param p the main game's drawer
	 */
	public void draw(PApplet p) {
		p.pushMatrix();
		p.pushStyle();
	
		// Draws the background of the inventory bar
		p.fill(darkgray, 200);
		p.rect(500, 350, 150, 525);
		
		// Draws the circle cutouts of the inventory bar
		p.fill(lightgray, 200);
		p.ellipseMode(p.RADIUS);
		p.ellipse(575, 425, 50, 50);
		p.ellipse(575, 550, 50, 50);
		p.ellipse(575, 675, 50, 50);
		p.ellipse(575, 800, 50, 50);
		
		// Draws the squares layred on the circles
		p.rectMode(p.RADIUS);
		p.rect(575, 425, 45, 45);
		p.rect(575, 550, 45, 45);
		p.rect(575, 675, 45, 45);
		p.rect(575, 800, 45, 45);
		p.rectMode(p.CORNER);
		
		// Draws each key in the player's inventory in the cutouts
		p.imageMode(p.CENTER);
		for(int i = 0; i < items.size(); i++) {
			items.get(i).draw(p, 575, 425 + 125 * i, 75);
		}
		
		p.popStyle();
		p.popMatrix();
	}
}
