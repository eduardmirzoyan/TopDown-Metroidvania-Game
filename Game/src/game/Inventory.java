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
		//System.out.println(item.getColor());
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
		p.fill(150);
		p.rect(100, 250, 525, 150);
		
		p.fill(255);
		p.ellipse(125, 275, 100, 100);	
		p.ellipse(250, 275, 100, 100);
		p.ellipse(375, 275, 100, 100);
		p.ellipse(500, 275, 100, 100);
		
		for(int i = 0; i < items.size(); i++) {
			items.get(i).draw(p, 150 + 125 * i, 300, 50);
		}
		
		p.popMatrix();
	}
}
