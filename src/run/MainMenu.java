package run;

import java.util.List;
import java.util.Scanner;

import thePet.StoreObjects;
import Game1.GamePlay;
import thePet.Pet;

public class MainMenu {

	private static String[] args = {};

	// for testing, seems to be working fine here
	public static void main(String[] args) {

		Pet myPet = new Pet("Bill", "M");
		
		myPet.setHealth(50);
		myPet.setEnergy(50);
		menu(myPet);
	}

	public static void menu(Pet myPet) {

		System.out.println();
		System.out.print("Welcome, " + myPet.getName() + ". ");

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

				while (true) {

					if (gamesIn.equals("Jump")) {

						//rn only jump1 works, see initJump for more
						StartScreen.initJump(myPet);
					}

					else if (gamesIn.equals("Castle")) {

						GamePlay.newProtagonist(myPet);
					}

					else if (gamesIn.equals("Back")) {
						menu(myPet);

					}

					else {

						System.out.println("Sorry we didn't quite get that, please type in your choice again");
						gamesIn = in.next();

					}

				}

			}

			else if (userInput.equals("Shop")) {

				// shop is bugged rn. some reason only printing out the last item in the shop
				shopMenu(myPet);

			}

			else if (userInput.equals("Care")) {

				// TODO give option of walk or feed
				while (true) {
					System.out.println("What would you like to do?");
					System.out.println("Feed Walk Back");
					userInput = in.next();

					if (userInput.equals("Feed")) {
						// TODO open up feed menu
						feedMenu(myPet);

					}

					if (userInput.equals("Walk")) {
						walkMenu(myPet);

					}

					if (userInput.equals("Back")) {
						menu(myPet);
					}

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
				System.out.println("Energy: " + myPet.getEnergy());
				System.out.println("Inventory Items: " );
				myPet.printInventory();
				menu(myPet);

			}

			else if (userInput.equals("SuperSecretCode")) {
				System.out.println("wow u found it gj");

			}

			else {

				System.out.println("Sorry we can't understand that");
				continue;

			}

		}

	}

	public static void feedMenu(Pet myPet) {
		
		
		if(myPet.getInventory().size() == 0) {
			System.out.println("Sorry you don't have any items to feed " + myPet.getName());
			menu(myPet);
		}
		
		
		Scanner in = new Scanner(System.in);
		int i = 0;

		List<StoreObjects> inv = myPet.getInventory();
		for (StoreObjects s : inv) {
			System.out.print(i + " ");
			System.out.println(s.toString());
			i++;
		}
		System.out.println("Please type in the number of the object you'd like to feed your pet");
		int toFeed = in.nextInt();
		in.nextLine();
		
		//check to make sure that the entered number is within inventory size
		if(toFeed> inv.size()-1 || toFeed < 0) {
			System.out.println("Sorry you don't have that item");
			feedMenu(myPet);
		}

		StoreObjects feedObj = inv.get(toFeed);
		myPet.addHealth(feedObj.getHealth());
		myPet.decreaseEnergy(feedObj.getEnergy());
		//TODO make sure this actually removes the item from the users inventory 
		myPet.removeInventory(inv.get(toFeed));

		System.out.println("WOW good job! Your Pet's stats are now: ");
		System.out.println("Name: " + myPet.getName());
		System.out.println("Gender: " + myPet.getGender());
		System.out.println("Level " + myPet.getLevel());
		System.out.println("Age: " + myPet.getAge());
		System.out.println("Points: " + myPet.getPoints());
		System.out.println("Health: " + myPet.getHealth());
		System.out.println("Energy: " + myPet.getEnergy());
		System.out.println("Inventory Items: ");
		myPet.printInventory();

		while (true) {
			System.out.println("Would you like to continue feeding or go back to the Main Menu?");
			System.out.println("*Feed*    *MainMenu*");

			String now = in.next();

			if (now.equals("Feed")) {

				feedMenu(myPet);
			}

			else if (now.equals("MainMenu")) {
				menu(myPet);
			}

			else {
				System.out.println("Sorry we can't understand that");
			}
		}
	}
	
	
	public static void walkMenu(Pet myPet) {
		System.out.println("How long of a walk would you like to take?");
		while(true) {
			System.out.println("*Short* *Long*");
			//TODO code choices
			
		}
		
		
	}
	
	public static void shopMenu(Pet myPet) {
		StoreObjects[] shopInv = StoreObjects.populateStore();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Shop! Here's what we have in stock\n");
		Shop.showShop();
		
		while(true) {
		System.out.println("Please enter in the item number of what you'd like to buy");
		System.out.println("You have:" + myPet.getPoints() + " points!");
		
		int userInput = in.nextInt();
		in.nextLine();
		
		if(userInput> 28 || userInput < 0) {
			System.out.println("Sorry we don't have that in stock right now,");
			System.out.println("How about something else?");
			continue;
			
			}
		
		else {
			StoreObjects toBuy = shopInv[userInput];
			
			if(myPet.getPoints() <= toBuy.getPrice()) {
				System.out.println("Sorry ur a broke boi �\\_(UwU)_/�, come back for that item later");
				System.out.println("In the mean time, how about you buy something more in your range");
				Shop.showShop();
				continue;
			}
			
			else {
				System.out.println("Congrats, " + toBuy.getName() + " has been added to your inventory");
				myPet.addInventory(toBuy);
				myPet.decreasePoints(toBuy.getPrice());
				menu(myPet);
			}
			
		}

		}
		
		
	}

}
