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
	
	public void draw(PApplet p) {
		p.pushMatrix();
		p.pushStyle();
	
		
		p.fill(100);
		//p.rect(100, 250, 525, 150);
		
		p.rect(500, 325, 150, 525);
		
		p.fill(255);
		
		
		p.ellipseMode(p.RADIUS);
		p.ellipse(575, 325 + 525 / 2, 50, 50);
		p.ellipse(300, 325, 50, 50);
		p.ellipse(425, 325, 50, 50);
		p.ellipse(550, 325, 50, 50);
		
		p.rectMode(p.RADIUS);
		p.rect(175, 325, 45, 45);
		p.rect(300, 325, 45, 45);
		p.rect(425, 325, 45, 45);
		p.rect(550, 325, 45, 45);
		
		p.rectMode(p.CORNER);
		
		for(int i = 0; i < items.size(); i++) {
			items.get(i).draw(p, 150 + 125 * i, 300, 50);
		}
		
		p.fill(150);
		p.rect(100, 200, 262, 50);
		
		p.fill(0);
		p.textSize(55);
		p.textAlign(p.CENTER, p.CENTER);
		p.text("Inventory", 100 + 262 / 2, 220);
		
		p.popStyle();
		p.popMatrix();
	}
}
