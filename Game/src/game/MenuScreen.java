package game;

import java.awt.Point;

import processing.core.*;

public class MenuScreen extends PApplet {

	public static boolean start = false;
	
	private PImage icon;
	private boolean showControls;
	
	public void setup() {
		icon = loadImage("images/icon.png");
		
		surface.setTitle("Menu Screen");
		surface.setIcon(icon);
	}
	
	public void settings(){
		size(800, 450);
	 }
	
	public void mousePressed() {
		if(showControls) {
			showControls = !showControls;
		}
		else {
			if (mouseX >= 400 - 100 && mouseX <= 400 + 100 && mouseY >= 150 - 75 / 2 && mouseY <= 150 + 75 / 2) {
				surface.setVisible(false);
				Game game = new Game();
				PApplet.runSketch(new String[]{"Main game"}, game);
			}
			if (mouseX >= 400 - 100 && mouseX <= 400 + 100 && mouseY >= 250 - 75 / 2 && mouseY <= 250 + 75 / 2) {
				showControls = !showControls;
			}
			if (mouseX >= 400 - 100 && mouseX <= 400 + 100 && mouseY >= 350 - 75 / 2 && mouseY <= 350 + 75 / 2) {
				System.exit(0);
			}
		}
	}
	
	public void startGame() {
		start = true;
	}
	
	public void draw() {
		background(47);
		
		fill(0);
		textSize(50);
		textAlign(CENTER, CENTER);
		text("Labyrinth", 400, 50);
		
		fill(106);
		rectMode(RADIUS);
		rect(400, 150, 100, 75 / 2);
		rect(400, 250, 100, 75 / 2);
		rect(400, 350, 100, 75 / 2);
		
		fill(0);
		textSize(25);
		text("Start Game", 400, 150-5);
		text("How to Play", 400, 250-5);
		text("Exit", 400, 350-5);
		
		if(showControls) {
			pushMatrix();
			fill(150);
			rect(400, 225, 300, 175);
			
			fill(0);
			textSize(35);
			String thankyou = "How to Play";
			text(thankyou, 400, 100);
			
			textSize(20);
			String instructions = "You are an adventurer who found a dungeon and decided to go exploring. After traveling for what seemed like hours, you decided to take a nap."
					+ " Mysteriously, when you awoke, you didn't seem to be in the same spot you fell asleep at...\n"
					+ "Armed with a map, your goal is straight forward, to escape the unknown dungeon (go up the stairs).\n"
					+ "Use the arrow keys or WASD to move and spacebar to interact.\n"
					+ "Press anywhere to go back to main menu.";
			text(instructions, 400, 250, 290, 150);
			
			popMatrix();
		}
		
	}
}
