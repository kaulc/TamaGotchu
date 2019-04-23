package run;

import java.util.Scanner;

import Game1.GamePlay;
import thePet.Pet;

public class MainMenu {

	private static String[] args = {};

	// for testing, seems to be working fine here
	public static void main(String[] args) {

	Pet myPet = new Pet("Bill", "M");
	menu(myPet);
	}

	public static void menu(Pet myPet) {

		System.out.println();
		System.out.print("Welcome, " + myPet.getName());

		Scanner in = new Scanner(System.in);

		while (true) {

			System.out.println("What would you like to do?");
			System.out.println("Games Shop Care Status");
			String userInput = in.next();

			if (userInput.equals("Games")) {

				String gamesIn = "";
				// Send them to games
				System.out.println("Which game would you like to play?");
				// Move "shop" into feed
				System.out.println("Jump   Castle   Back");

				gamesIn += in.next();

				

					if (gamesIn.equals("Jump")) {

						StartScreen.initJump(myPet);
					}

					else if (gamesIn.equals("Castle")) {

						GamePlay.main(args, myPet);
					}
					
					else if(gamesIn.equals("Back")) {
						menu(myPet);
						
					}

					else {

						System.out.println("Sorry we didn't quite get that, please type in your choice again");
						gamesIn = in.next();

					}

				

			}

			else if (userInput.equals("Shop")) {

				// shop is bugged rn. some reason only printing out the last item in the shop
				System.out.println("Welcome to the Shop! Here's what we have in stock\n");
				Shop.showShop();
				System.out.println("Please enter in the item number of what you'd like to buy");
				//either add more here or create a shop method to handle transactions

			}

			else if (userInput.equals("Care")) {

				// TODO give option of walk or feed
				System.out.println("What would you like to do?");
				System.out.println("Feed Walk Back");
				userInput = in.next();
				
				if(userInput.equals("Feed")) {
					//TODO open up feed menu
					
				}
				
				if(userInput.equals("Walk")) {
					//TODO walk menu? differnet lengths? idk maybe just a plain + something
					
				}
				
				if(userInput.equals("Back")) {
					continue;
				}

			}

			else if (userInput.equals("Status")) {

				// Print out status and offer them to make another choice
				System.out.println("Name: " + myPet.getName());
				System.out.println("Gender: " + myPet.getGender());
				System.out.println("Level " + myPet.getLevel());
				System.out.println("Age: " + myPet.getAge());
				System.out.println("Points: " + myPet.getPoints());
				System.out.println("Health: " + myPet.getHealth());
				System.out.println("Hunger: " + myPet.getHunger());
				System.out.println("Inventory Items: " + myPet.getInventory());
				menu(myPet);

			}

			else if (userInput.equals("SuperSecretCode")) {
				// output super secret easter egg

			}

			else {

				System.out.println("Sorry we can't understand that");
				continue;

			}

		}

	}

}
