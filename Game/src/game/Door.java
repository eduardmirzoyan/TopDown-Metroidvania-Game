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
	
	public void setSprite(PImage i) {
		sprite = i;
	}
	
	public void setColor(String i) {
		color = i;
	}
	
	public String getColor() {
		return color;
	}
	
	public void draw(PApplet p, int x, int y, int size) {
		p.pushMatrix();
		
		p.image(sprite, x, y, size, size);
		
		p.popMatrix();
	}
	
	public boolean unlock(Inventory inv) {
		if(inv.removeKey(color)) {
			return true;
		}
		else {
			return false;
		}
	}
}
