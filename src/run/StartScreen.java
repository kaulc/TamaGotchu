package run;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JWindow;



public class StartScreen {
	
	private final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public StartScreen() {
		
		JWindow win = new JWindow();
		JLabel text = new JLabel("Start");
		
		text.setHorizontalAlignment(JTextField.CENTER);
		text.setVerticalAlignment(JLabel.CENTER);
		
		win.setSize(screenSize);
		win.setLocation(0, 0);
		win.add(text);
		win.setVisible(true);
		
		
	}

}
