package game;
/**
 * @version 1.0
 */
import processing.core.*;
import rooms.*;

public class Game extends PApplet {
	
	public static final int gameSize = 18; // The size of the game grid
	public static final int cellSize = 50; // The pixel size of each grid square

	//IMPORTANT currentLoc is in x,y form while grid is y, x form
	
	private String[][] map; // The array of characters to determine what goes where
	private String[][] location = new String[gameSize][gameSize]; // An array layered on the map that dictates the player's position
	Player player; // The controllable player
	MessageFeed messageFeed; // The interaction message feedback
	MiniMap miniMap; // The minimap the player can use to see their position
	
	//Sprites
	PImage icon, cross, blank, exit, wall, floor, background, playerFront, playerBack, playerLeft, playerRight;

	// The room in which to draw and the player is currently in
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
	
	// Is the game beaten?
	private boolean isBeat;
	
	// Sets the window to a nonchangable 16:9 ratio
	public void settings(){
		size(1600,900);
	 }

	/**
	 * Initializes most fields and loads all images to be used.
	 * Prepares the game elements. Also spawns the player
	 */
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
	
	/**
	 * Enables movement through arrow keys or WASD
	 * Space is used to interact
	 * Checks the spot the player is currently at or is going to go
	 */
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
		
		if ((keyCode == UP || keyCode == 'W') && player.getY() - 1 >= 0 && !map[currentY - 1][currentX].equals("W") && !map[currentY - 1][currentX].equals("M") && !isBeat) {
			action(currentX, currentY, currentX, currentY - 1);
			player.setImage(playerBack);
		}
		if ((keyCode == LEFT || keyCode == 'A')&& player.getX() - 1 >= 0 && !map[currentY][currentX - 1].equals("W") && !map[currentY][currentX - 1].equals("M") && !isBeat) {
			action(currentX, currentY, currentX - 1, currentY);
			player.setImage(playerRight);
		}
		if ((keyCode == DOWN || keyCode == 'S') && player.getY() + 1 < gameSize && !map[currentY + 1][currentX].equals("W") && !map[currentY + 1][currentX].equals("M") && !isBeat) {
			action(currentX, currentY, currentX, currentY + 1);
			player.setImage(playerFront);
		}
		if ((keyCode == RIGHT || keyCode == 'D') && player.getX() + 1 < gameSize && !map[currentY][currentX + 1].equals("W") && !map[currentY][currentX + 1].equals("M") && !isBeat) {
			action(currentX, currentY, currentX + 1, currentY);
			player.setImage(playerLeft);
		}
		
		checkMapChange();
	}
	
	/**
	 * The most common action of the player, to open a door.
	 * Checks if player has the key that is the same color as the door
	 * If true, removes the door and key and moves player forward
	 * If false, gives feedback
	 * @param currentX current x cord of player
	 * @param currentY current y cord of player
	 * @param newX the x cord of where the player WANTS to be
	 * @param newY the y cord of where the player WANTS to be
	 */
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
	
	/**
	 * Checks if the player is at the edge of the game scren to change maps
	 * Checks the currents rooms entrance locations and then changes the current room
	 */
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
	
	/*
	 * Presents a thank you screen to the user
	 */
	private void winScreen() {
		pushMatrix();
		pushStyle();
		
		// Rectangle background for the message
		rectMode(RADIUS);
		strokeWeight(10);
		stroke(0);
		fill(150);
		rect(800, 450, 400, 200);
		
		// Text message printed on the rectangle
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
	
	/*
	 * Draws all the game elements on the screen such as map, inventory, messagefeed and minimap
	 */
	public void draw() {
		// Draws background art
		background(background);
		noStroke();
		// Draws the box of message feedback of interactions
		messageFeed.draw(this);
		
		// Draws all the main game pieces such as doors keys and walls
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				// Draws the walls and floors
				if(map[j][i].equals("W")) {
					image(wall, 700 + i * cellSize, j * cellSize, cellSize, cellSize);
				}
				else {
					image(floor, 700 + i * cellSize, j * cellSize, cellSize, cellSize);
				}
				
				// Draws invisible walls
				if(map[j][i].equals("M")) {
					image(blank, 700 + i * cellSize, j * cellSize, cellSize, cellSize);
				} 
				// Draws the exit staircase
				if(map[j][i].equals("#")) {
					image(exit, 700 + i * cellSize,  j * cellSize, cellSize, cellSize);
				}
				// Draws the doors
				if(map[j][i].equals("&")) {
					currentRoom.getDoor(i, j).draw(this, 700 + i * cellSize, j * cellSize, cellSize);
				}
				// Draws the keys
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
		
		// If the game is won, draws the win message
		if(isBeat) {
			winScreen();
		}
	}
	
	/**
	 * Sets the room to be drawn to the input room
	 * @param r input room
	 */
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
