package run;

import java.util.Scanner;

import thePet.Pet;

public class MainMenu {

	public static void menu(Pet myPet) {

		System.out.println();
		System.out.print("Welcome" + myPet.getName());
		System.out.println("What would you like to do?");
		System.out.println("Games Feed Walk Status");
		Scanner user = new Scanner(System.in);
		String userInput = user.next();

//		while (!userInput.equals("Games") && !userInput.equals("Feed") && !userInput.equals("Walk")
//				&& !userInput.equals("Status")) {

		//should be able to use whlie(true) since I'll be calling other methods from within this, if there seem to be 
		//error we can check back here
		//FIXME
		while(true) {
			if (userInput.equals("Games")) {

				// Send them to games
				System.out.println("Which game would you like to play?");
				//Move "shop" into feed
				System.out.println("Jump   Castle");
				
				userInput = user.next();
				
				while(true) {
					
					if(userInput.equals("Jump")) {
						
						StartScreen.initJump();
					}
					
					else if(userInput.equals("Castle")) {
						
						//send to castle
					}
					
					else {
						
						System.out.println("Sorry we didn't quite get that, please type in your choice again");
						userInput = user.next();
											
					}
					
				}
				

			}

			else if (userInput.equals("Feed")) {

				//add shop to the bottom if the user has no items
				// Send to feed menu
				
				
				
				

			}

			else if (userInput.equals("Walk")) {

				// Walk or Send to walk menu??

			}

			else if (userInput.equals("Status")) {

				//Print out status and offer them to make another choice
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

				System.out.println(
						"Oops, we can't quite tell what you wanted to do, please enter what you'd like to do again");
				userInput = user.next();

			}

		}

	}

}
