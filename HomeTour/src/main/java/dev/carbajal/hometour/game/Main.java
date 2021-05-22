package dev.carbajal.hometour.game;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	static String[] userInput;
	static boolean gameStatus = true;
	static RoomManager rm = new RoomManager(9);
	static Player guest = new Player();

	public static void main(String[] args) {

		// Creating the rooms and the player's starting position

		rm.init();		
		guest.setCurrentRoom(rm.getStartingRoom());

		// Introduction text just to create a silly scenario~

		System.out.println("Welcome Human Customer #2576! \nI, Hospitality A.I. Ver. 2.1, will be serving as your Home Tour Guide today! \n\nOur Real Estate Agency is suggesting this house "
				+ "to you based on your specified budget and needs. \nWhile you have already seen several homes, I hop that today is the lucky day you find your dream house! \nNow! Onto "
				+ "the tour~! Feel free to stop and 'look around' at any point in time. *wink wink* \nYou can also let me know a specific direction that you would like to travel. \n"
				+ "You can also end the tour at anytime by letting me know you'd like to 'Leave', but why would you ever want to? Ha ha ha...");

		// Running the Home Tour!

		while (gameStatus != false) {

			// Print Current Room's Name and Short Description as currentRoom changes

			printRoom(guest);

			collectInput();

			// Quit if user inputs 'leave'

			for (int i = 0; i < userInput.length; i++) {

				if (userInput[i].equalsIgnoreCase("leave")) {

					gameStatus = false;
				} 
			}

			// Otherwise Home Tour continues

			parse(userInput, guest);

			// get exit and change room if exit exists, otherwise tell user not a valid direction to move

			

		}

	}

	// Methods

	private static void printRoom(Player p) {

		System.out.println(p.getCurrentRoom().getName());
		System.out.println("");
		System.out.println(p.getCurrentRoom().getShortDesc());

	}

	private static String[] collectInput() {

		userInput = scanner.nextLine().split(" ");
		return userInput;

	}

	private static void parse(String[] command, Player p)  {

		for (int i = 0; i < command.length; i++) {

			// Print Current Room's Long Description if user inputs 'look' keyword

			if (command[i].equalsIgnoreCase("look")) {

				System.out.println(p.getCurrentRoom().getLongDesc());
			} 

			// Get exits if user inputs direction

			else if (command[i].equalsIgnoreCase("north")) {

				

			} else if (command[i].equalsIgnoreCase("south")) {

				

			} else if (command[i].equalsIgnoreCase("east")) {

				

			} else if (command[i].equalsIgnoreCase("west")) {

				

			}

			// can also use if else to parse for item names (if in that room) and print out a description here

		}

	}

}
