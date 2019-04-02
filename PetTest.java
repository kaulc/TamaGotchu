package thePet;

import java.util.ArrayList;
import java.util.Scanner;

import thePet.Pet;

	public class PetTest {
			
		public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Hello, welcome!");
			//System.out.print("Would you like to load from file??");
			
			//System.out.print("Which Pet would you like? (1, 2, 3)");
			//String mainInput = input.next();
			
			System.out.print("Please enter in the name for your new pet: ");
			String pName = input.next();
			
			System.out.print("\n Is your pet Male or Female? (M/F)");
			String pGender = input.next();  
			
			String itemName = null;
			int price = 0;
			int health = 0;
			int hunger = 0;
			
			StoreObjects item = new StoreObjects(itemName, price, health, hunger);
			Pet yourPet = new Pet(pName, pGender);
			
			
			System.out.println("Hi, " + yourPet.getName() + " it's nice to meet you!");
			
			System.out.println("Games    Feed     Walk    Status");
			
			String mainInput = input.next();
			
			if(mainInput.equals("Games")) {
				System.out.println("Jump   Castle   Fight   Shop");
				
				String gamesInput = input.next();
				
				if (gamesInput.equals("Shop")) {
					
					
					yourPet.addInventory(item);
					yourPet.decreasePoints(price);
					yourPet.decreaseHunger(hunger);
					yourPet.healthIncrease(health);
					
				}
			}
			
			else if(mainInput.equals("Feed")) {
				System.out.println("What would you like to feed your pet?");
				System.out.print(yourPet.getInventory());
				String feedInput = input.next();
				while(feedInput == item.name) {
					yourPet.decreaseHunger(item.hunger);
				}
			}
			
			else if(mainInput.equals("Walk")) {
				if (yourPet.getHealth() == 100) {
					System.out.println("Your pet is already healhy");
				}
				else {
					System.out.println("Congrats! Your pet is healthier!");
					if ((yourPet.getHealth() + 25) >= 100 ) {
						yourPet.setHealth(100);
					}
					else {
						yourPet.healthIncrease(25);
					}
				}
			}
			
			
			else if (mainInput.equals("Status")) {
				System.out.println("Name: " + yourPet.getName());
				System.out.println("Gender: " + yourPet.getGender());
				System.out.println("Level " + yourPet.getLevel());
				System.out.println("Age: " + yourPet.getAge());
				System.out.println("Points: " + yourPet.getPoints());
				System.out.println("Health: " + yourPet.getHealth());
				System.out.println("Hunger: " + yourPet.getHunger());
				System.out.println("Inventory Items: " + yourPet.getInventory());
			}
			
			
				
			
		}
			
			
		
		

	}



