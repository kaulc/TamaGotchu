package run;

import java.util.Scanner;

import thePet.Pet;
import thePet.StoreObjects;

public class InitPet {
	
	public static Pet initPet() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Hello, friend!");
		System.out.println("Welcome to TamaGotchu.");
		
		System.out.println("First, please type your pet's name: ");			
		String pName = input.next();
		System.out.print("Next, is your pet Male or Female? (M/F/O)");
		String pGender = input.next();  
		while(!pGender.equals("M") && !pGender.equals("F") && !pGender.equals("O")) {
			System.out.println("Oops sorry, we didn't quite get that");
			System.out.println("Is your pet Male, Female or Other? (M/F/O)");
			pGender = input.next();
		}
		
//		String itemName = null;
//		int price = 0;
//		int health = 0;
//		int hunger = 0;
//		
//	
//		idk why this is here but ill ask ANI about it
//		StoreObjects item = new StoreObjects(itemName, price, health, hunger);
		
		input.close();
		
		return  new Pet(pName, pGender);

		
	//TODO figure out how I want to pass the pet around and where I want shit running from!!
	}

}
