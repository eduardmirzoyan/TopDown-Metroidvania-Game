package game;
/**
 * @version 1.0
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
	MessageFeed messageFeed;
	MiniMap miniMap;
	
	//Sprites
	PImage icon, cross, blank, exit, wall, floor, background, playerFront, playerBack, playerLeft, playerRight;

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
	
	private boolean isBeat;
	
	public void settings(){
		size(1600,900);
	 }

	//Always runs after any constructor
	//Make sure every gridspace isnt null
	public void setup() {
		miniMap = new MiniMap();
		messageFeed = new MessageFeed();
		isBeat = false;
		
		icon = loadImage("images/icon.png");
		exit = loadImage("images/stairs.png");
		cross = loadImage("images/cross.png");
		blank = loadImage("images/blank.png");
		wall = loadImage("images/wall.png");
		floor = loadImage("images/floor.png");
		background = loadImage("images/background.jpg");
		playerFront = loadImage("images/link.png");
		playerBack = loadImage("images/linkback.png");
		playerLeft = loadImage("images/linkleft.png");
		playerRight = loadImage("images/linkright.png");
		
		PImage yellowKey = loadImage("images/keys/yellowkey.png");
		PImage blueKey = loadImage("images/keys/bluekey.png");
		PImage redKey = loadImage("images/keys/redkey.png");
		PImage greenKey = loadImage("images/keys/greenkey.png");
		PImage orangeKey = loadImage("images/keys/orangekey.png");
		PImage purpleKey = loadImage("images/keys/purplekey.png");
		PImage brownKey = loadImage("images/keys/brownkey.png");
		PImage blackKey = loadImage("images/keys/blackkey.png");
		PImage whiteKey = loadImage("images/keys/whitekey.png");
		PImage neonKey = loadImage("images/keys/neonkey.png");
		PImage turkKey = loadImage("images/keys/turkkey.png");
		PImage pinkKey = loadImage("images/keys/pinkkey.png");
		PImage grayKey = loadImage("images/keys/graykey.png");
		PImage skyKey = loadImage("images/keys/skykey.png");

		PImage yellowDoor = loadImage("images/doors/yellowdoor.png");
		PImage blueDoor = loadImage("images/doors/bluedoor.png");
		PImage redDoor = loadImage("images/doors/reddoor.png");
		PImage greenDoor = loadImage("images/doors/greendoor.png");
		PImage orangeDoor = loadImage("images/doors/orangedoor.png");
		PImage purpleDoor = loadImage("images/doors/purpledoor.png");
		PImage brownDoor = loadImage("images/doors/browndoor.png");
		PImage blackDoor = loadImage("images/doors/blackdoor.png");
		PImage whiteDoor = loadImage("images/doors/whitedoor.png");
		PImage neonDoor = loadImage("images/doors/neondoor.png");
		PImage turkDoor = loadImage("images/doors/turkdoor.png");
		PImage pinkDoor = loadImage("images/doors/pinkdoor.png");
		PImage grayDoor = loadImage("images/doors/graydoor.png");
		PImage skyDoor = loadImage("images/doors/skydoor.png");
		
		surface.setTitle("Labyrinth");
		surface.setIcon(icon);
		
		miniMap.setImage(cross);
		
		room1 = new TopLeft(redKey, purpleKey, grayDoor, pinkDoor);
		room2 = new TopMiddle(grayKey, orangeKey, skyDoor);
		room3 = new TopRight(turkKey, purpleDoor, neonDoor);
		
		room4 = new MiddleLeft();
		room5 = new MiddleMiddle(yellowKey, skyKey, pinkKey, brownKey, yellowDoor, blueDoor, redDoor, greenDoor, blackDoor);
		room6 = new MiddleRight(neonKey, blueKey, whiteKey, brownDoor, orangeDoor);
		
		room7 = new BottomLeft(greenKey, turkDoor);
		room8 = new BottomMiddle(whiteDoor);
		room9 = new BottomRight(blackKey);
		
		currentRoom = room5;
		map = currentRoom.getRoom();
		
		messageFeed.addMessage("You wake up on the cold, stone ground...");
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				location[j][i] = "EMPTY";
				if(map[j][i].equals("X")) {
					player = new Player(i, j, playerFront);
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
				isBeat = !isBeat;
				if(isBeat)
					messageFeed.addMessage("You climb the stairs...");
			}
			if(map[currentY][currentX].equals("@")) {
				if(player.getInventory().addKey(currentRoom.getKey(currentX, currentY))) {
					messageFeed.addMessage("You've picked up a " + player.getInventory().getNewest().getColor() + " key!");
				}
				else {
					messageFeed.addMessage("Your inventory is full.");
				}
				
				map[(int) player.getY()][(int) player.getX()] = "*";
			}
			
		}
		
		if (keyCode == UP && player.getY() - 1 >= 0 && !map[currentY - 1][currentX].equals("W") && !map[currentY - 1][currentX].equals("M") && !isBeat) {
			action(currentX, currentY, currentX, currentY - 1);
			player.setImage(playerBack);
		}
		if (keyCode == LEFT && player.getX() - 1 >= 0 && !map[currentY][currentX - 1].equals("W") && !map[currentY][currentX - 1].equals("M") && !isBeat) {
			action(currentX, currentY, currentX - 1, currentY);
			player.setImage(playerRight);
		}
		if (keyCode == DOWN && player.getY() + 1 < gameSize && !map[currentY + 1][currentX].equals("W") && !map[currentY + 1][currentX].equals("M") && !isBeat) {
			action(currentX, currentY, currentX, currentY + 1);
			player.setImage(playerFront);
		}
		if (keyCode == RIGHT && player.getX() + 1 < gameSize && !map[currentY][currentX + 1].equals("W") && !map[currentY][currentX + 1].equals("M") && !isBeat) {
			action(currentX, currentY, currentX + 1, currentY);
			player.setImage(playerLeft);
		}
		
		checkMapChange();
	}
	
	private void action(int currentX, int currentY, int newX, int newY) {
		if(map[newY][newX].equals("&")) {
			if(currentRoom.getDoor(newX, newY).unlock(player.getInventory())) {
				map[newY][newX] = "*";
				messageFeed.addMessage("You unlock the door.");
				
				player.relocate(newX, newY);
				relocate(currentX, currentY);
			}
			else {
				 messageFeed.addMessage("You need a " + currentRoom.getDoor(newX, newY).getColor()  + " key!");
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
	
	private void winScreen() {
		pushMatrix();
		pushStyle();
		
		rectMode(RADIUS);
		strokeWeight(10);
		stroke(0);
		fill(150);
		rect(800, 450, 400, 200);
		
		fill(0);
		textSize(50);
		textAlign(CENTER, CENTER);
		text("Congratulations!", 800, 300);
		textSize(20);
		text("You have beat the game. I hope it wasn't too hard. This is as far as the current state of the game goes. "
				+ "Hopefully, you noticed someone of the jokes laid throughout the game. This was a personal project that started from highschool and finished after a yearlong gap. "
				+ "I tried to add as much creative things that fit the layout of the game. I may or may not return to update and/or polish this game, but my PayPal is always open. "
				+ "Anyways, thank you for playing my game. This game was entirely imagined and coded by Eduard Mirzoyan", 800, 460, 390, 120);
		text("Press space to exit.", 800, 600, 390, 120);
		
		popStyle();
		popMatrix();
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
		background(background);
		noStroke();
		messageFeed.draw(this);
		
		// Draws all the playable board for the player such as doors keys and walls
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				fill(200);
				if(map[j][i].equals("W")) {
					image(wall, 700 + i * cellSize, j * cellSize, cellSize, cellSize);
				}
				else {
					image(floor, 700 + i * cellSize, j * cellSize, cellSize, cellSize);
				}
				
				if(map[j][i].equals("M")) {
					image(blank, 700 + i * cellSize, j * cellSize, cellSize, cellSize);
				} 
				if(map[j][i].equals("#")) {
					image(exit, 700 + i * cellSize,  j * cellSize, cellSize, cellSize);
				}
				if(map[j][i].equals("&")) {
					currentRoom.getDoor(i, j).draw(this, 700 + i * cellSize, j * cellSize, cellSize);
				}
				if(map[j][i].equals("@")) {
					currentRoom.getKey(i, j).draw(this, 700 + i * cellSize, j * cellSize, cellSize);
				}
				
				
				//Draws player
				if(location[j][i].equals("PLAYER")) {
					player.draw(this, 700 + i * cellSize,  j * cellSize, cellSize);
				}
			}
		}
		
		// Draws the minimap on screen
		miniMap.draw(this);
		
		// Draws the players inventory on screen
		player.getInventory().draw(this);
		
		if(isBeat) {
			winScreen();
		}
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
