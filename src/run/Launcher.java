package run;

import thePet.Pet;

public class Launcher {

	public static void main(String[] args) {
		
		StartScreen.initScreen();
		Pet thePet = InitPet.initPet();
		MainMenu.menu(thePet);
		
		

	}

}
