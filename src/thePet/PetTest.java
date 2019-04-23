package thePet;

import java.util.ArrayList;
import run.Launcher;
import run.StartScreen;
import pro.JUMP;
import Game1.GamePlay;

import java.util.Scanner;

import contralar.Contralar;
import gnu.io.SerialPortEventListener;
import thePet.Pet;

	public class PetTest {
			
		public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in);
			System.out.println("Hello, welcome!");
			
			System.out.print("Type your pet's name: ");			
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
				System.out.println("Jump   Castle   Shop");
				String gamesInput = input.next();
				
				if (gamesInput.equals("Jump")) {
					//Launcher.main(args);
					StartScreen.initScreen();
					
				}
				
				if (gamesInput.equals("Castle")) {
					GamePlay.main(args);
					
				}
				
				
				if (gamesInput.equals("Shop")) {
					System.out.println("Press the number for the item, attributes are price, health, and hunger: " +
							"\n\nShirts:\n" +
							"0. Green Shirt (200, 0, 0)\n" + 
							"1. Blue Shirt (200, 0, 0)\n" + 
							"2. Red Shirt (200, 0, 0)\n" + 
							"3. Yellow Shirt (200, 0, 0)\n" + 
							"4. Gold Shirt (1000, 0, 0)\n" + 
							"\nPants\n" +
							"5. Green Pants (300, 0, 0)\n" + 
							"6. Blue Pants (300, 0, 0)\n" + 
							"7. Red Pants (300, 0, 0)\n" + 
							"8. Yellow Pants (300, 0, 0)\n" + 
							"9. Gold Pants (1500, 0, 0)\n" + 
							"\nShoes\n" +
							"10. Nike Shoes (500, 0, 0)\n" + 
							"11. Adidas Shoes (500, 0, 0)\n" + 
							"12. Jordans (750, 0, 0)\n" + 
							"13. Vans (300, 0, 0)\n" + 
							"14. Yeezys (1500, 0, 0)\n" +
							"\nFood\n" +
							"15. Cheese\", 300, 75, 75)\n" + 
							"16. Beef (300, 75, 75)\n" + 
							"17. Beans (250, 70, 70)\n" + 
							"18. Soup (100, 25, 25)\n" + 
							"19. Cake (500, 100, 100)\n" + 
							"\nDrinks\n" +
							"20. Water (50, 15, 15)\n" + 
							"21. Apple Juice (100, 25, 25)\n" + 
							"22. Orange Juice (100, 25, 25)\n" + 
							"23. Milk (150, 40, 40)\n" + 
							"24. Chocolate Milk (500, 100,100)\n" + 
							"\nPotions\n" + 
							"25. Mild Potion (100, 25, 25)\n" + 
							"26. Medium Potion (200, 50, 50)\n" + 
							"27. Good Potion (300, 75, 75)\n" + 
							"28. Best Potion (500, 100, 100)");
					String shopInput = input.next();
					int itemNum = Integer.parseInt(shopInput);
					
					yourPet.addInventory(item.getItem(itemNum));
					yourPet.decreasePoints(item.getItem(itemNum).price);
					yourPet.decreaseHunger(item.getItem(itemNum).hunger);
					yourPet.healthIncrease(item.getItem(itemNum).health);
					
					System.out.println("Points: " + yourPet.getPoints());
					System.out.println("Inventory Items: " + yourPet.getInventory());
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



