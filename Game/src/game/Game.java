package game;
/**
 * @version 0.4
 */
import java.awt.Point;
import processing.core.*;

public class Game extends PApplet {
	
	public static final int gameSize = 18;
	public static final int cellSize = 50;

	//IMPORTANT currentLoc is in x,y form while grid is y,x form
	
//	private String[][] map = {
//			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
//			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "*", "*", "*", "*", "*", "*", "&", "*", "*", "*", "*", "*", "*", "#", "*", "W"},
//			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
//			{"W", "W", "W", "W", "W", "W", "W", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "W", "W", "W", "W", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "W", "*", "*", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "*", "*", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "W", "W", "W", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "@", "*", "W"},
//			{"W", "X", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
//			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
//		};
	
	private String[][] map;
	private String[][] location = new String[gameSize][gameSize];
	Player player;
	//Room rooms;
	
	private MiddleMiddle room1 = new MiddleMiddle();
	private MiddleLeft room2 = new MiddleLeft();
	private MiddleRight room3 = new MiddleRight();
	private TopMiddle room4 = new TopMiddle();
	private BottomMiddle room5 = new BottomMiddle();
	
	private Room currentRoom;
	
	private boolean hasKey = false;
	private String message;
	
	//Sprite
	PImage stairs;
	PImage door;
	PImage key;
	PImage icon;
	
	public void settings(){
		size(1600,900);
	 }

	//Always runs after any constructor
	//Make sure every gridspace isnt null
	public void setup() {
		stairs = loadImage("images/stairs.png");
		door = loadImage("images/door.png");
		key = loadImage("images/key.png");
		icon = loadImage("images/icon.png");
		
		surface.setTitle("Dungeon");
		surface.setIcon(icon);
		
		currentRoom = room1;
		map = currentRoom.getRoom();
		
		message = "Welcome to the alpha of my game, use arrow keys to move and space to interact";
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				location[j][i] = "EMPTY";
				if(map[j][i].equals("X")) {
					player = new Player(i, j);
					//player.relocate(i, j);
					location[j][i] = "PLAYER";
				}
			}
		}
		ellipseMode(CORNER);
		
	}
	
//	private Point clickToIndex(Point p, float x, float y) {
//		p = new Point((int) (p.getX() - 700), (int) (p.getY()));
//		if (p.getX() > cellSize * gameSize || p.getY() > cellSize * gameSize || p.getX() < 0 || p.getY() < 0) {
//			return null;
//		}s
//
//		return new Point((int) ((p.getY() + y) / cellSize), (int) ((p.getX() + x) / cellSize));
//	}

	public void act() {
		int previousX = (int) player.getX();
		int previousY = (int) player.getY();
		if(map[(int) player.getY()][(int) player.getX()].equals("E")) {
			player.setLocation(currentRoom.changeRoom(player.getLocation(), this));
			relocate(previousX, previousY);
		}
		
		map = currentRoom.getRoom();
	}
	
	public void keyPressed() {
		int previousX = (int) player.getX();
		int previousY = (int) player.getY();
		
		if(keyCode == 32) {
			if(map[(int) player.getY()][(int) player.getX()].equals("#")) {
				message = "You've escaped!";
			}
			if(map[(int) player.getY()][(int) player.getX()].equals("@")) {
				hasKey = true;
				message = "You've grabbed a key!";
				map[(int) player.getY()][(int) player.getX()] = "*";
			}
		}
		
		if (keyCode == UP && player.getY() - 1 >= 0 && !map[(int) player.getY() - 1][(int) player.getX()].equals("W")) {
			player.relocate((int) player.getX(), (int) player.getY() - 1);
			relocate(previousX, previousY);
		}
		if (keyCode == LEFT && player.getX() - 1 >= 0 && !map[(int) player.getY()][(int) player.getX() - 1].equals("W")) {
			player.relocate((int) player.getX() - 1, (int) player.getY());
			relocate(previousX, previousY);
		}
		if (keyCode == DOWN && player.getY() + 1 < gameSize && !map[(int) player.getY() + 1][(int) player.getX()].equals("W")) {
			player.relocate((int) player.getX(), (int) player.getY() + 1);
			relocate(previousX, previousY);
		}
		if (keyCode == RIGHT && player.getX() + 1 < gameSize && !map[(int) player.getY()][(int) player.getX() + 1].equals("W")) {
			if(map[(int) player.getY()][(int) player.getX() + 1].equals("&") && !hasKey) {
				message = "You need a key!";
			} else {
				player.relocate((int) player.getX() + 1, (int) player.getY());
				relocate(previousX, previousY);
			}
			
		}
		
		act();
	}
	
	/**
	 * Sets hopefully updated location of player and deletes previous location
	 * @pre new location is different than previous
	 * @param x x value of previous location
	 * @param y y value of previous location
	 */
	private void relocate(int x, int y) {
		location[(int) player.getY()][(int) player.getX()] = "PLAYER";
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
				//Draws inventory and map stuff
				

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
	
	
	public void setCurrentRoom(Room r) {
		currentRoom = r;
	}
	
	public Room getMiddleMiddle() {
		return room1;
	}
	
	public Room getMiddleLeft() {
		return room2;
	}
	
	public Room getMiddleRight() {
		return room3;
	}
	
	public Room getTopMiddle() {
		return room4;
	}
	
	public Room getBottomMiddle() {
		return room5;
	}
}
