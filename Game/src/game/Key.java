package game;

import processing.core.PApplet;
import processing.core.PImage;

public class Key {

	private String color;
	private PImage sprite;
	
	public Key(String col) {
		color = col;
	}
	
	public Key(String col, PImage img) {
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

}
