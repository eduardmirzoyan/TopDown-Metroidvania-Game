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
	
	/**
	 * 
	 * @param i The image to set this key's sprite
	 */
	public void setSprite(PImage i) {
		sprite = i;
	}
	
	/**
	 * 
	 * @param i The color to set this key's color
	 */
	public void setColor(String i) {
		color = i;
	}
	
	/**
	 * 
	 * @return The color of this key
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * 
	 * @param p The PApplet to draw this key on
	 * @param x The topleft x cord of the key
	 * @param y The topleft y cord of the key
	 * @param size The height and width of the key
	 */
	public void draw(PApplet p, int x, int y, int size) {
		p.pushMatrix();
		
		p.image(sprite, x, y, size, size);
		
		p.popMatrix();
	}

}
