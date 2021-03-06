package run;

import java.util.List;
import java.util.Scanner;

import thePet.Pet;
import thePet.StoreObjects;

/**
 * Shows shop, gives user option to buy things based on how many coins they've earned in games
 *
 */
public class Shop {
	
	
	//for testing
	public static void main(String[] args) {
		Pet myPet = new Pet("bob", "M");
		
		showShop();
	}
	
	
	public static void showShop() {
		
		StoreObjects[] items = new StoreObjects[30];
		
		 items[0] = new StoreObjects("Green Shirt", 200, 0, 0);
		 items[1] = new StoreObjects("Blue Shirt", 200, 0 , 0);
		 items[2] = new StoreObjects("Red Shirt", 200, 0 , 0);
		 items[3] = new StoreObjects("Yellow Shirt", 200, 0 , 0);
		 items[4] = new StoreObjects("Gold Shirt", 1000, 0 , 0);
		 
		 
		 items[5] = new StoreObjects("Green Pants", 300, 0, 0);
		 items[6] = new StoreObjects("Blue Pants", 300, 0 , 0);
		 items[7] = new StoreObjects("Red Pants", 300, 0 , 0);
		 items[8] = new StoreObjects("Yellow Pants", 300, 0 , 0);
		 items[9] = new StoreObjects("Gold Pants", 1500, 0 , 0);
		 
		 
		 items[10] = new StoreObjects("Nikes", 500, 0, 0);
		 items[11] = new StoreObjects("Adidas", 500, 0 , 0);
		 items[12] = new StoreObjects("Jordans", 750, 0 , 0);
		 items[13] = new StoreObjects("Vans", 300, 0 , 0);
		 items[14] = new StoreObjects("Yeezys", 1500, 0 , 0);
		 
		 
		 items[15] = new StoreObjects("Cheese", 300, 75, 75);
		 items[16] = new StoreObjects("Beef", 300, 75, 75);
		 items[17] = new StoreObjects("Beans", 250, 70, 70);
		 items[18] = new StoreObjects("Soup", 100, 25, 25);
		 items[19] = new StoreObjects("Cake", 500, 100, 100);
		 
		 
		 items[20] = new StoreObjects("Water", 50, 15, 15);
		 items[21] = new StoreObjects("Apple Juice", 100, 25 , 25);
		 items[22] = new StoreObjects("Orange Juice", 100, 25 , 25);
		 items[23] = new StoreObjects("Milk", 150, 40 , 40);
		 items[24] = new StoreObjects("Chocolate Milk", 500, 100 , 100);	
		 
		 
		 items[25] = new StoreObjects("Mild Potion", 100, 25, 25);
		 items[26] = new StoreObjects("Medium Potion", 200, 50 , 50);
		 items[27] = new StoreObjects("Good Potion", 300, 75, 75);
		 items[28] = new StoreObjects("Best Potion", 500, 100, 100);
		 items[29] = new StoreObjects("MainMenu", 99999, 0, 0);
		
		
		
		
		System.out.printf("%-15s %-6s %-6s %-6s\n", "Item", "Cost", "Health", "Energy" );
		
		for(int i =0; i< items.length; i++ ) {
			
				StoreObjects s = items[i];
				String a = s.toString();
				System.out.print(i + " ");
				System.out.println(a);
		
		}
		
	}
	
	
	
	

}
