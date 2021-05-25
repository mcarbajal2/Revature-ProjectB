package dev.carbajal.hometour.game;

import dev.carbajal.hometour.fixtures.Room;

public class RoomManager {

	private Room startingRoom;
	private Room[] rooms;

	// Constructor

	public RoomManager(int count) {

		rooms = new Room[count];
	}

	// Getters and Setters

	public Room getStartingRoom() {

		return startingRoom;
	}

	public void setStartingRoom(Room startingRoom) {

		this.startingRoom = startingRoom;
	}

	public Room[] getRooms() {

		return rooms;
	}

	public void setRooms(Room[] rooms) {

		this.rooms = rooms;
	}

	// Initialization Method

	public void init() {

		Room yard = new Room ("--Yard--",
				"Ahhh that freshy cut grass smell.", 
				"A newly built blue house stands in the middle of a decent-sized field \n"
						+ "of green grass. There is a mailbox at the end of the sidewalk leading \n"
						+ "out to the main road. A yellow front door happily greets all vistors.");

		Room dining = new Room ("--Dining Room--", 
				"A brightly lit dining area.", 
				"Located at the entrance of the house, the dining room has plenty of \n"
						+ "room for plently of people. Natural ceiling lighting and bright \n"
						+ "wallpaper also add to the joyful energy of the room you feel.");
		
		Room kitchen = new Room ("--Kitchen--", 
				"The counterspace is any cooking enthusiasts's dream come true.", 
				"Shiny new appliances and a great deal of countertop space quickly catches \n"
						+ "your eye! The kitchen island is also a nice addition and you start \n"
						+ "imagining how many loaves of bread you could whip up on that.");
		
		Room living = new Room ("--Living Room--", 
				"That's a comfy looking couch.", 
				"At the very center of the area a couch you can feel yourself sinking \n"
						+ "into at the end of a long day proudly sits. There is also a \n"
						+ "sturdy-looking coffee table and a rather...interesting pattern.\n"
						+ "It's 20XX and somehow fluffy cheetah print rugs still exist?!");
		
		Room masterBed = new Room ("--Bedroom--", 
				"The Master bedroom.", 
				"A beautifully decorated space for the main future occupents of the house. \n"
						+ "There is a giant walk-in closet in the corner that catches your attention.");
		
		Room masterBath = new Room ("--Bathroom--", 
				"The Master bathroom.", 
				"A homey bathroom, with lots of plush floor mats. There is also a large soaking \n"
						+ "tub in the middle of the room. Perfect for lazy days!!");
		
		Room bed = new Room ("--Bedroom--", 
				"Another bedroom, probably meant for guest stay.", 
				"A decent-sized bedroom that could also be turned into a home office, a gym, \n"
						+ "etc. if desired!");
		
		Room bath = new Room ("--Bathroom--", 
				"The guest bedroom's adjacent bathroom.", 
				"This bathroom sports a shower and although the furnishings are quaint \n"
				+ "it is still rather nicely decorated.");
		
		Room patio = new Room ("--Patio--", 
				"The backyard and patio area.", 
				"Past the sliding doors sits a patio area with space for outdoor seating. \n"
						+ "There is also a grill and a small fire pit, great for any get-togethers!");

		this.rooms[0] = yard;
		this.rooms[1] = dining;
		this.rooms[2] = kitchen;
		this.rooms[3] = living;
		this.rooms[4] = masterBed;
		this.rooms[5] = masterBath;
		this.rooms[6] = bed;
		this.rooms[7] = bath;
		this.rooms[8] = patio;
		
		// Room exit directions = {north (index 0), south (index 1), east (index 2), west (index 3)}
		
		Room[] yardExits = {dining, null, null, null};
		
		Room[] diningExits = {living, yard, masterBed, kitchen};
		
		Room[] kitchenExits = {null, null, dining, null};
		
		Room[] livingExits = {patio, dining, bed, null};
		
		Room[] masterBedExits = {null, masterBath, null, dining};
		
		Room[] masterBathExits = {masterBed, null, null, null};
		
		Room[] bedExits = {null, bath, null, living};
		
		Room[] bathExits = {bed, null, null, null};
		
		Room[] patioExits = {null, living, null, null};
		
		yard.setExits(yardExits);
		dining.setExits(diningExits);
		kitchen.setExits(kitchenExits);
		living.setExits(livingExits);
		masterBed.setExits(masterBedExits);
		masterBath.setExits(masterBathExits);
		bed.setExits(bedExits);
		bath.setExits(bathExits);
		patio.setExits(patioExits);

		setStartingRoom(yard);

	}
}
