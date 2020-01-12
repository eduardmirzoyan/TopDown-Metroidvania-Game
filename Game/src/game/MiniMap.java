package game;

import processing.core.PApplet;
import processing.core.PImage;

public class MiniMap {

	
	private int location;
	private String locationName;
	private PImage cross;
	private final int darkgray = 47, lightgray = 106, midgray = 200;
	
	public MiniMap() {
		location = 5;
	}
	
	public MiniMap(int n) {
		location = n;
	}
	
	public void draw(PApplet p) {
		p.pushMatrix();
		p.pushStyle();
		
		p.translate(-200, 0);
		
		p.fill(darkgray, 200);
		p.rect(250, 450, 400, 400);
		p.fill(lightgray, 200);
		
		p.textSize(40);
		
		if(location == 1) {
			p.fill(midgray, 200);
			locationName = "Prison Cells";
		}
		p.rect(275, 475, 100, 100);
		if(location == 1)
			p.fill(lightgray, 200);
		
		if(location == 2) {
			p.fill(midgray, 200);
			locationName = "Isn't this Tic-Tac-Toe?";
		}
		p.rect(400, 475, 100, 100);
		if(location == 2) {
			p.fill(lightgray, 200);
			if(cross != null) {
				p.image(cross, 400, 475, 100, 100);
			}
		}
		
		if(location == 3) {
			p.fill(midgray, 200);
			locationName = "High in the Clouds";
		}
		p.rect(525, 475, 100, 100);
		if(location == 3)
			p.fill(lightgray, 200);
		
		if(location == 4) {
			p.fill(midgray, 200);
			locationName = "Name of the Game";
		}
		p.rect(275, 600, 100, 100);
		if(location == 4)
			p.fill(lightgray, 200);
		
		if(location == 5) {
			p.fill(midgray, 200);
			locationName = "The Beginning";
		}
		p.rect(400, 600, 100, 100);
		if(location == 5)
			p.fill(lightgray, 200);
		
		if(location == 6) {
			p.fill(midgray, 200);
			locationName = "Home Sweet Home";
		}
		p.rect(525, 600, 100, 100);
		if(location == 6)
			p.fill(lightgray, 200);
		
		if(location == 7) {
			p.fill(midgray, 200);
			locationName = "Two Sides of the Same Coin";
			p.textSize(30);
		}
		p.rect(275, 725, 100, 100);
		if(location == 7)
			p.fill(lightgray, 200);
		
		if(location == 8) {
			p.fill(midgray, 200);
			locationName = "The Journey...";
		}
		p.rect(400, 725, 100, 100);
		if(location == 8)
			p.fill(lightgray, 200);
		
		if(location == 9) {
			p.fill(midgray, 200);
			locationName = "...The Reward?";
		}
		p.rect(525, 725, 100, 100);
		if(location == 9)
			p.fill(lightgray, 200);
		
		p.stroke(0);
		p.fill(darkgray, 200);
		p.rect(250, 400, 400, 50);
		
		p.fill(0);
		p.textAlign(p.CENTER, p.CENTER);
		p.text(locationName, 450, 425);
		
		p.popStyle();
		p.popMatrix();
	}
	
	public void setLocation(int n) {
		location = n;
	}
	
	public void setImage(PImage p) {
		cross = p;
	}
}
