package game;
/**
 * @version 0.4
 */
import processing.core.*;
import rooms.*;

public class Game extends PApplet {
	
	public static final int gameSize = 18;
	public static final int cellSize = 50;

	//IMPORTANT currentLoc is in x,y form while grid is y, x form
	
	private String[][] map;
	private String[][] location = new String[gameSize][gameSize];
	Player player;
	
	//Sprites
	PImage icon, stairs, blueDoor, yellowDoor, yellowKey, blueKey;
	
	MiniMap miniMap = new MiniMap();

	private Room currentRoom;
	
	private TopLeft room1;
	private TopMiddle room2;
	private TopRight room3;
	
	private MiddleLeft room4;
	private MiddleMiddle room5;
	private MiddleRight room6;
	
	private BottomLeft room7;
	private BottomMiddle room8;
	private BottomRight room9;
	
	private String message; 
	
	
	public void settings(){
		size(1600,900);
	 }

	//Always runs after any constructor
	//Make sure every gridspace isnt null
	public void setup() {
		icon = loadImage("images/icon.png");
		stairs = loadImage("images/stairs.png");
		
		blueDoor = loadImage("images/bluedoor.png");
		yellowDoor = loadImage("images/yellowdoor.png");
		yellowKey = loadImage("images/yellowkey.png");
		blueKey = loadImage("images/bluekey.png");
		
		
		surface.setTitle("Dungeon");
		surface.setIcon(icon);
		
		
		room1 = new TopLeft();
		room2 = new TopMiddle();
		room3 = new TopRight();
		
		room4 = new MiddleLeft();
		room5 = new MiddleMiddle(yellowKey, blueKey, yellowDoor, blueDoor);
		room6 = new MiddleRight();
		
		room7 = new BottomLeft();
		room8 = new BottomMiddle();
		room9 = new BottomRight();
		
		currentRoom = room5;
		map = currentRoom.getRoom();
		
		message = "Welcome to the alpha of my game, use arrow keys to move and space to interact";
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				location[j][i] = "EMPTY";
				if(map[j][i].equals("X")) {
					player = new Player(i, j);
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
	
	public void keyPressed() {
		int currentX = (int) player.getX();
		int currentY = (int) player.getY();
		
		// code 32 is the spacebar
		if(keyCode == 32) {
			if(map[currentY][currentX].equals("#")) {
				message = "You've escaped!";
			}
			if(map[currentY][currentX].equals("@")) {
				
				if(player.getInventory().addKey(currentRoom.getKey(currentX, currentY))) {
					message = "You've picked up a key!";
				}
				else {
					message = "Your inventory is full.";
				}
				
				map[(int) player.getY()][(int) player.getX()] = "*";
			}
		}
		
		if (keyCode == UP && player.getY() - 1 >= 0 && !map[currentY - 1][currentX].equals("W")) {
			action(currentX, currentY, currentX, currentY - 1);
		}
		if (keyCode == LEFT && player.getX() - 1 >= 0 && !map[currentY][currentX - 1].equals("W")) {
			action(currentX, currentY, currentX - 1, currentY);
		}
		if (keyCode == DOWN && player.getY() + 1 < gameSize && !map[currentY + 1][currentX].equals("W")) {
			action(currentX, currentY, currentX, currentY + 1);
		}
		if (keyCode == RIGHT && player.getX() + 1 < gameSize && !map[currentY][currentX + 1].equals("W")) {
			action(currentX, currentY, currentX + 1, currentY);
		}
		
		checkMapChange();
	}
	
	private void action(int currentX, int currentY, int newX, int newY) {
		if(map[newY][newX].equals("&")) {
			if(currentRoom.getDoor(newX, newY).unlock(player.getInventory())) {
				map[newY][newX] = "*";
				message = "You unlock the door.";
				
				player.relocate(newX, newY);
				relocate(currentX, currentY);
			}
			else {
				message = "You need a key!";
			}
		}
		else {
			player.relocate(newX, newY);
			relocate(currentX, currentY);
		}
	}
	
	private void checkMapChange() {
		int previousX = (int) player.getX();
		int previousY = (int) player.getY();
		if(map[(int) player.getY()][(int) player.getX()].equals("E")) {
			player.setLocation(currentRoom.changeRoom(player.getLocation(), this));
			relocate(previousX, previousY);
		}
		
		map = currentRoom.getRoom();
		miniMap.setLocation(currentRoom.getCode());
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
		fill(0);
		textSize(25);
		text(message, 50, 50, 600, 100);
		noStroke();
		
		// Draws all the playable board for the player such as doors keys and walls
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				fill(200);
				if(map[j][i].equals("W")) {
					fill(100);
				} 
				rect(700 + i * cellSize, j * cellSize, cellSize, cellSize);
				
				if(map[j][i].equals("#")) {
					image(stairs, 700 + i * cellSize,  j * cellSize, cellSize, cellSize);
				}
				if(map[j][i].equals("&")) {
					currentRoom.getDoor(i, j).draw(this, 700 + i * cellSize, j * cellSize, cellSize);
				}
				if(map[j][i].equals("@")) {
					//currentRoom.getKey(i, j).draw(this, 700 + i * cellSize, j * cellSize, cellSize);
				}
				
				
				//Draws player
				if(location[j][i].equals("PLAYER")) {
					fill(255);
					ellipse(700 + i * cellSize + 10,  j * cellSize + 10, cellSize - 20, cellSize - 20);
				}
			}
		}
		
		// Draws the minimap on screen
		miniMap.draw(this);
		
		// Draws the players inventory on screen
		player.getInventory().draw(this);
	}
	
	public void setCurrentRoom(Room r) {
		currentRoom = r;
	}
	
	public Room getTopLeft() {
		return room1;
	}
	
	public Room getTopMiddle() {
		return room2;
	}
	
	public Room getTopRight() {
		return room3;
	}
	
	public Room getMiddleLeft() {
		return room4;
	}
	
	public Room getMiddleMiddle() {
		return room5;
	}
	
	public Room getMiddleRight() {
		return room6;
	}
	
	public Room getBottomLeft() {
		return room7;
	}
	
	public Room getBottomMiddle() {
		return room8;
	}

	public Room getBottomRight() {
		return room9;
	}
}
