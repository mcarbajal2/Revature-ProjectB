package dev.carbajal.hometour.fixtures;

public class Room extends Fixture{
	
	private Room[] roomExits = new Room[9];
	
	// Constructor
	
	public Room(String name, String shortDesc, String longDesc) {
		
		super(name, shortDesc, longDesc);
		
	}
	
	// Getters and Setters

	public void setExits(Room[] roomExits) {
		
		this.roomExits = roomExits;
	}
		
	public Room getExit(Room room, String userInput) {
					
		if (userInput.equalsIgnoreCase("north")) {
			
			room = roomExits[0];
			
		} else if (userInput.equalsIgnoreCase("south")) {
			
			room = roomExits[1];
			
		} else if (userInput.equalsIgnoreCase("east")) {
			
			room = roomExits[2];
			
		} else if (userInput.equalsIgnoreCase("west")) {
			
			room = roomExits[3];
			
		}
		
		return room;
	}
}
