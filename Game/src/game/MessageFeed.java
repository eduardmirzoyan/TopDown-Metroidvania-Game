package game;

import java.util.ArrayList;

import processing.core.PApplet;

public class MessageFeed {

	private ArrayList<String> messages;
	private final int messageCap = 5;
	
	public MessageFeed() {
		 messages = new ArrayList<String>();
	}

	public void addMessage(String s) {
		if(messages.size() < messageCap) {
			messages.add(s);
		}
		if(messages.size() >= messageCap) {
			messages.remove(0);
			messages.add(s);
		}
	}
	
	public void draw(PApplet p) {
		p.pushMatrix();
		p.pushStyle();
				
		p.fill(47, 126);
		p.rect(40, 90, 620, 220);
		p.fill(106, 126);
		p.rect(50, 100, 600, 200);
		
		p.stroke(0);
		p.fill(0, 126);
		p.textSize(25);
		for(int i = messages.size() - 1; i >= 0 ; i--) {
			p.text(messages.get(i), 60, 265 - (messages.size() - i - 1) * 40, 580, 40);
		}
		
		p.popStyle();
		p.popMatrix();
	}
}
