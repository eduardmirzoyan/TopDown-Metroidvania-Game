package game;

import java.util.ArrayList;

import processing.core.PApplet;

public class Inventory {

	ArrayList<Key> items;
	
	public Inventory() {
		 items = new ArrayList<Key>();
	}
	
	public boolean addKey(Key item) {
		if(items.size() > 4) {
			return false;
		}
		items.add(item);
		return true;
	}
	
	public boolean removeKey(String color) {
		for(int i = 0; i < items.size(); i++) {
			if(color == items.get(i).getColor()) {
				items.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Key getNewest() {
		return items.get(items.size() - 1);
	}
	
	public void draw(PApplet p) {
		p.pushMatrix();
		p.pushStyle();
	
		// Draws the background of the inventory bar
		p.fill(100);
		p.rect(500, 350, 150, 525);
		
		// Draws the circle cutouts of the inventory bar
		p.fill(255);
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
		
		/*
		// Draws the nameplate for the label
		p.fill(150);
		p.rect(100, 200, 262, 50);
		
		// Formats and draws the Inventory label
		p.fill(0);
		p.textSize(55);
		p.textAlign(p.CENTER, p.CENTER);
		p.text("Inventory", 100 + 262 / 2, 220);
		*/
		
		p.popStyle();
		p.popMatrix();
	}
}
