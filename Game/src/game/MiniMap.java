package game;

import processing.core.PApplet;

public class MiniMap {

	private int location;
	
	public MiniMap() {
		location = 5;
	}
	
	public MiniMap(int n) {
		location = n;
	}
	
	public void draw(PApplet p) {
		p.pushMatrix();
		p.fill(100);
		p.rect(250, 450, 400, 400);
		p.fill(255);
		
		if(location == 1)
			p.fill(150);
		p.rect(275, 475, 100, 100);
		if(location == 1)
			p.fill(255);
		
		if(location == 2)
			p.fill(150);
		p.rect(400, 475, 100, 100);
		if(location == 2)
			p.fill(255);
		
		if(location == 3)
			p.fill(150);
		p.rect(525, 475, 100, 100);
		if(location == 3)
			p.fill(255);
		
		
		if(location == 4)
			p.fill(150);
		p.rect(275, 600, 100, 100);
		if(location == 4)
			p.fill(255);
		
		if(location == 5)
			p.fill(150);
		p.rect(400, 600, 100, 100);
		if(location == 5)
			p.fill(255);
		
		if(location == 6)
			p.fill(150);
		p.rect(525, 600, 100, 100);
		if(location == 6)
			p.fill(255);
		
		
		if(location == 7)
			p.fill(150);
		p.rect(275, 725, 100, 100);
		if(location == 7)
			p.fill(255);
		
		if(location == 8)
			p.fill(150);
		p.rect(400, 725, 100, 100);
		if(location == 8)
			p.fill(255);
		
		if(location == 9)
			p.fill(150);
		p.rect(525, 725, 100, 100);
		if(location == 9)
			p.fill(255);
		
		p.popMatrix();
	}
	
	public void setLocation(int n) {
		location = n;
	}
}
