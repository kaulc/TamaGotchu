package earlyPet;

import java.util.Scanner;

public class PetTest {
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Hello, welcome!");
		//"Would you like to load from file??"
				
		System.out.print("Please enter in the name for your new TamaGotChu: ");
		
		String pName = in.next();
		
		System.out.print("\n Is your TamaGotChu Male? (Y/N)");
		
		boolean pGender = (in.next()== "Y");  
		
		Pet guy = new Pet(pName, pGender);
		
		System.out.println("Wow, " + guy.getName() + " can't wait to meet you");
		
		System.out.println("Games    Feed     Walk    Status");
		
		String mainInput = in.next();
		
		if(mainInput.equals("Games")) {
			System.out.println("Jump   Fall   Fight   Shop");
		}
		
		else if(mainInput.equals("Feed")) {
			System.out.println("What would you like to feed your pet?");
			System.out.print("Grapes   Crackers   Bacon   Steak");
			String feedInput = in.next();
			
			
		}
		
		
		
	}
	
	

}
