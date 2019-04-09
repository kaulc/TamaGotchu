package thePet;

import java.util.TooManyListenersException;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class ChooseName {

	public static void main(String[] args) {
		
		game h = new game();

	}
}
	
	class game implements SerialPortEventListener{
		Controller g = new Controller();
		
		public game() {
			try {
				
				g.ReturnPort().addEventListener(this);
				System.out.print("David     Chinar    Simon     Ani");
			} catch (TooManyListenersException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void serialEvent(SerialPortEvent e) {
			if (e.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
				String b = g.buttonPress();
				if(b.equals("m")) {
					System.out.print("David");
					String pName = "David";
				}
				else if(b.equals("1")) {
					System.out.print("Chinar");
					String pName = "Chinar";
				}
				else if(b.equals("2")) {
					System.out.print("Simon");
					String pName = "Simon";
				}
				else if(b.equals("3")) {
					System.out.print("Ani");
					String pName = "Ani";
				}
			}
		}
		
	}
	


