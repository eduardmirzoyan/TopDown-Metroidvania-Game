package game;

import processing.core.PApplet;

public class MiniMap {

	private int location;
	private String locationName;
	
	public MiniMap() {
		location = 5;
		locationName = "The beginning.";
	}
	
	public MiniMap(int n) {
		location = n;
	}
	
	public void draw(PApplet p) {
		p.pushMatrix();
		p.pushStyle();
		
		p.translate(-200, 0);
		
		p.fill(100);
		p.rect(250, 450, 400, 400);
		p.fill(255);
		
		if(location == 1) {
			p.fill(150);
			locationName = "Prison Cells";
		}
		p.rect(275, 475, 100, 100);
		if(location == 1)
			p.fill(255);
		
		if(location == 2) {
			p.fill(150);
			locationName = "Isn't this Tic-Tac-Toe?";
		}
		p.rect(400, 475, 100, 100);
		if(location == 2)
			p.fill(255);
		
		if(location == 3) {
			p.fill(150);
			locationName = "High in the Clouds";
		}
		p.rect(525, 475, 100, 100);
		if(location == 3)
			p.fill(255);
		
		if(location == 4) {
			p.fill(150);
			locationName = "Name of the Game";
		}
		p.rect(275, 600, 100, 100);
		if(location == 4)
			p.fill(255);
		
		if(location == 5) {
			p.fill(150);
			locationName = "The beginning";
		}
		p.rect(400, 600, 100, 100);
		if(location == 5)
			p.fill(255);
		
		if(location == 6) {
			p.fill(150);
			locationName = "Home Sweet Home";
		}
		p.rect(525, 600, 100, 100);
		if(location == 6)
			p.fill(255);
		
		if(location == 7) {
			p.fill(150);
			locationName = "Two Sides of the Same Coin";
		}
		p.rect(275, 725, 100, 100);
		if(location == 7)
			p.fill(255);
		
		if(location == 8) {
			p.fill(150);
			locationName = "The Journey...";
		}
		p.rect(400, 725, 100, 100);
		if(location == 8)
			p.fill(255);
		
		if(location == 9) {
			p.fill(150);
			locationName = "...The Reward?";
		}
		p.rect(525, 725, 100, 100);
		if(location == 9)
			p.fill(255);
		
		p.fill(150);
		p.rect(250, 400, 400, 50);
		
		p.fill(0);
		p.textSize(40);
		p.textAlign(p.CENTER, p.CENTER);
		p.text(locationName, 450, 425);
		
		p.popStyle();
		p.popMatrix();
	}
	
	public void setLocation(int n) {
		location = n;
	}
}
