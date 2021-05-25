package dev.carbajal.hometour.game;

import java.util.Scanner;

import dev.carbajal.hometour.fixtures.Room;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	static boolean gameStatus = true;
	static RoomManager rm = new RoomManager(9);
	static Player guest = new Player();
	static String[] userInput;
	static Room currentRoom;
	static String userChoice;
	static String direction;


	public static void main(String[] args) {

		// Creating the rooms and setting the player's starting position

		rm.init();		
		guest.setCurrentRoom(rm.getStartingRoom());

		// Introduction text just to create a silly scenario~

		System.out.println("Welcome Human Customer #2576! \nI, Hospitality A.I. Ver. 2.1, will be serving as your Home Tour Guide today! \n\nOur Real Estate Agency is suggesting this house "
				+ "to you based on your\nspecified budget and needs. While you have already seen several homes, \nI hope that today is the lucky day you find your dream house! Now!\nOnto "
				+ "the tour~! Feel free to stop and 'look around' at any point in time.\n*wink wink* \nYou can also let me know a direction (North/South/etc.) that you would like to travel. \n"
				+ "\nEnd this tour at anytime by letting me know you'd like to 'leave', but why would you ever want to?\nHa ha ha ha ha...\n___________________________________________________"
				+ "_______________________________________________\n");

		// Running the Home Tour!

		printRoom(guest);

		while (gameStatus != false) {

			collectInput();

			parse(userInput, guest);

			if (userChoice != null) {

				switch (userChoice) {

				// Quit if user inputs 'leave'

				case "leave":

					System.out.println("\nAlright I hope you enjoyed the tour! If this place\nsuits your needs please ring up the Agency "
							+ "later\nand let us know, we'll get you situated straight away!\n\nGoodbye!! ");
					gameStatus = false;
					break;

					// Print Current Room's Long Description if user inputs 'look' keyword

				case "look":

					System.out.println(guest.getCurrentRoom().getLongDesc());
					break;

				case "move":

					// Set the Player's Current Room to the exit if a valid one was chosen by the user

					switch (direction) {

					case "north":

						guest.setCurrentRoom(guest.getCurrentRoom().getExit(currentRoom, "north"));
						printRoom(guest);
						break;

					case "south":

						guest.setCurrentRoom(guest.getCurrentRoom().getExit(currentRoom, "south"));
						printRoom(guest);
						break;

					case "east":

						guest.setCurrentRoom(guest.getCurrentRoom().getExit(currentRoom, "east"));
						printRoom(guest);
						break;

					case "west":

						guest.setCurrentRoom(guest.getCurrentRoom().getExit(currentRoom, "west"));
						printRoom(guest);
						break;

					default:
						break;
					}

					break;

				default:
					break;
				}

			} else {
				continue;
			}
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

			if (userInput[i].equalsIgnoreCase("leave")) {

				userChoice = "leave";
			} 

			else if (command[i].equalsIgnoreCase("look")) {

				// can also parse for "look at" for item (checking if in that room) and print out a description here if time

				userChoice = "look";
				break;
			} 

			// Get exits if user inputs a direction

			else if (command[i].equalsIgnoreCase("north")) {

				if (guest.getCurrentRoom().getExit(currentRoom, "north") != null) {

					userChoice = "move";
					direction = "north";
					break;

				} else {

					userChoice = "invalid";
					System.out.println("Silly human there is nothing to see in that direction!\n"
							+ "Try going another way.\n");
				}

			} else if (command[i].equalsIgnoreCase("south")) {

				if (guest.getCurrentRoom().getExit(currentRoom, "south") != null) {

					userChoice = "move";
					direction = "south";
					break;

				} else {

					userChoice = "invalid";
					System.out.println("Silly human there is nothing to see in that direction!\n"
							+ "Try going another way.\n");
				}

			} else if (command[i].equalsIgnoreCase("east")) {

				if (guest.getCurrentRoom().getExit(currentRoom, "east") != null) {

					userChoice = "move";
					direction = "east";
					break;

				} else {

					userChoice = "invalid";
					System.out.println("Silly human there is nothing to see in that direction!\n"
							+ "Try going another way.\n");
				}

			} else if (command[i].equalsIgnoreCase("west")) {

				if (guest.getCurrentRoom().getExit(currentRoom, "west") != null) {

					userChoice = "move";
					direction = "west";
					break;

				} else {

					userChoice = "invalid";
					System.out.println("Silly human there is nothing to see in that direction!\n"
							+ "Try going another way.\n");
				}

			} else {

				userChoice = "invalid";
				System.out.println("I'm sorry, my human speech recognition software doesn't recognize some of those words!\n"
						+ "Please try again!!!\n");
			}
		}
	}
}
