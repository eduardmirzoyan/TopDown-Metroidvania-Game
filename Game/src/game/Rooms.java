package game;

import java.util.ArrayList;

public class Rooms {

	private String[][] middleMiddle = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "&", "*", "*", "*", "*", "*", "*", "#", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"*", "*", "*", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "W", "W", "W", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "*", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "@", "*", "W"},
			{"W", "X", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
	
	private String[][] middleLeft = {
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "*", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "*"},
			{"W", "*", "W", "W", "W", "W", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "*", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "*", "W", "*", "W", "*", "W", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "*", "*", "*", "*", "*", "W", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "W"},
			{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
		};
	ArrayList<String[][]> rooms = new ArrayList<String[][]>();
	
	public Rooms() {
		rooms.add(middleMiddle);
		rooms.add(middleLeft);
	}
	
	public String[][] getRoom(int number){
		return rooms.get(number);
	}
	
}