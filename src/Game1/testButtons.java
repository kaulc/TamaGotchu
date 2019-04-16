package Game1;

import java.util.TooManyListenersException;

import contralar.Contralar;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class testButtons {

	public static void main(String[] args) {
		Game game1 = new Game();
		
	}
}

class Game {
	Contralar controller = new Contralar();
	GamePlay gp = new GamePlay(); 
	
	public Game() {

		try {
			controller.ReturnPort().addEventListener((SerialPortEventListener) this);
		} catch (TooManyListenersException e) {
			e.printStackTrace();
		}
	}

	public void gameMenu(SerialPortEvent e) {
		
		if (e.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			
			String str = controller.buttonPress();
			if(str.equals("m")) { // main menu
				System.out.println("menu button");
				gp.setPlay(false);
			}
			else if(str.equals("1")) { // play
				gp.setPlay(true);  
			} 
			else if(str.equals("2")) { // exit
				System.out.println("Okay thanks for playing, bye");
				
			}
			else if(str.equals("3")) { // stats
				System.out.println("Health = " + gp.getProtagonist().getHealth());
				System.out.println("Level = " + gp.getProtagonist().getLevel());
				System.out.println("Hunger = " + gp.getProtagonist().getHunger());
				System.out.println("Points = " + gp.getProtagonist().getPoints());
			}
	}
	}
}
