package game;

import processing.core.PApplet;

public class Door {
	
	String color;

	public Door() {
		
	}
	
	public Door(String col) {
		color = col;
	}
	
	public void draw(PApplet p) {
		p.pushMatrix();
		
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
