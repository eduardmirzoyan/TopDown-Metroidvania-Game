package Game;

import java.awt.Point;

import processing.core.PApplet;
import processing.core.PImage;

public class Game extends PApplet {
	
	public static final int gameSize = 18;
	public static final int cellSize = 50;

	//IMPORTANT currentLoc is in x,y form while grid is y,x form
	
	private String[][] map = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "&", "*", "*", "*", "*", "*", "*", "#", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "W", "W", "W", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "*", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "@", "*", "W"},
			{"W", "X", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
	private String[][] location = new String[gameSize][gameSize];
	private Point currentLoc;
	private boolean hasKey = false;
	private String message;
	
	//Sprites
	PImage stairs;
	PImage door;
	PImage key;
	
	public static void main(String[] args) {
		PApplet.main("Game");
	}
	
	public Game() {
		
	}
	
	//Always runs after any constructor
	//Make sure every gridspace isnt null
	public void setup() {
		
		message = "Welcome to the alpha of my game, use arrow keys to move and space to interact";
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				location[j][i] = "EMPTY";
				if(map[j][i].equals("X")) {
					currentLoc = new Point(i, j);
					location[j][i] = "PLAYER";
				}
			}
		}
		ellipseMode(CORNER);
		stairs = loadImage("images/stairs.png");
		door = loadImage("images/door.png");
		key = loadImage("images/key.png");
	}
	
	private Point clickToIndex(Point p, float x, float y) {
		p = new Point((int) (p.getX() - 700), (int) (p.getY()));
		if (p.getX() > cellSize * gameSize || p.getY() > cellSize * gameSize || p.getX() < 0 || p.getY() < 0) {
			return null;
		}
		
		return new Point((int) ((p.getY() + y) / cellSize), (int) ((p.getX()  + x) / cellSize));
	}
	
	public void mousePressed() {
		
	}
	
	public void keyPressed() {
		int previousX = (int) currentLoc.getX();
		int previousY = (int) currentLoc.getY();
		
		if(keyCode == 32) {
			if(map[(int) currentLoc.getY()][(int) currentLoc.getX()].equals("#")) {
				message = "You've escaped!";
			}
			if(map[(int) currentLoc.getY()][(int) currentLoc.getX()].equals("@")) {
				hasKey = true;
				message = "You've grabbed a key!";
				map[(int) currentLoc.getY()][(int) currentLoc.getX()] = "*";
			}
		}
		
		if (keyCode == UP && currentLoc.getY() - 1 >= 0 && !map[(int) currentLoc.getY() - 1][(int) currentLoc.getX()].equals("W")) {
				currentLoc = new Point((int) currentLoc.getX(), (int) currentLoc.getY() - 1);
				relocate(previousX, previousY);
		}
		if (keyCode == LEFT && currentLoc.getX() - 1 >= 0 && !map[(int) currentLoc.getY()][(int) currentLoc.getX() - 1].equals("W")) {
			currentLoc = new Point((int) currentLoc.getX() - 1, (int) currentLoc.getY());
			relocate(previousX, previousY);
		}
		if (keyCode == DOWN && currentLoc.getY() + 1 < gameSize && !map[(int) currentLoc.getY() + 1][(int) currentLoc.getX()].equals("W")) {
			currentLoc = new Point((int) currentLoc.getX(), (int) currentLoc.getY() + 1);
			relocate(previousX, previousY);
		}
		if (keyCode == RIGHT && currentLoc.getX() + 1 < gameSize && !map[(int) currentLoc.getY()][(int) currentLoc.getX() + 1].equals("W")) {
			if((map[(int) currentLoc.getY()][(int) currentLoc.getX() + 1].equals("&") && !hasKey)) {
				message = "You need a key!";
			} else {
				currentLoc = new Point((int) currentLoc.getX() + 1, (int) currentLoc.getY());
				relocate(previousX, previousY);
			}
			
		}
	}
	
	/**
	 * Sets hopefully updated location of player and deletes previous location
	 * @pre new location is different than previous
	 * @param x x value of previous location
	 * @param y y value of previous location
	 */
	private void relocate(int x, int y) {
		location[(int) currentLoc.getY()][(int) currentLoc.getX()] = "PLAYER";
		location[y][x] = "EMPTY";
	}
	
	//j,i = x,y
	public void draw() {
		background(255);
		stroke(0);
		text(message, 50, 50);
		noStroke();
		
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				//Draws side stuff
				
				
				//Draws map
				fill(200);
				if(map[j][i].equals("W")) {
					fill(100);
				} 
				rect(700 + i * cellSize, j * cellSize, cellSize, cellSize);
				
				if(map[j][i].equals("#")) {
					image(stairs, 700 + i * cellSize,  j * cellSize, cellSize, cellSize);
				}
				if(map[j][i].equals("&")) {
					image(door, 700 + i * cellSize,  j * cellSize, cellSize, cellSize);
				}
				if(map[j][i].equals("@")) {
					image(key, 700 + i * cellSize,  j * cellSize, cellSize, cellSize);
				}
				
				//Draws player
				if(location[j][i].equals("PLAYER")) {
					fill(255);
					ellipse(700 + i * cellSize + 10,  j * cellSize + 10, cellSize - 20, cellSize - 20);
				}
			}
		}
	}
	
	
	
}