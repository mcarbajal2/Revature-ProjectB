package dev.carbajal.hometour.game;

import dev.carbajal.hometour.fixtures.Room;

public class Player {
	
	Room currentRoom;
	
	public Room getCurrentRoom() {
		
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		
		this.currentRoom = currentRoom;
	}
}
