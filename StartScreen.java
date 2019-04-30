package run;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JWindow;

import pro.JUMP;
import pro.JUMP2;
import pro.JUMP3;
import thePet.Pet;
//import thePet.PetTest;

public class StartScreen {
	private static Color myC0 = new Color(164, 196, 0, 254);

	//private static String[] args = {};
	private final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static Font bold = new Font("bold", Font.BOLD, screenSize.height/20);
	private static Font normal = new Font("normal", Font.PLAIN, screenSize.height/30);
	
	private JWindow win;

	public StartScreen() {

		win = new JWindow();
	}

	public static void initScreen() {

		StartScreen screen = new StartScreen();

		JLabel text = new JLabel("<html> <br><br><br>Start</html>");
		text.setFont(bold);

		text.setHorizontalAlignment(JTextField.CENTER);
		text.setVerticalAlignment(JLabel.TOP);
		
		JButton button = new JButton("Lets Go!");
		button.setHorizontalAlignment(JTextField.CENTER);
		button.setVerticalAlignment(JLabel.CENTER);
		button.setBounds(screenSize.width/2, screenSize.height/2, screenSize.width/20, screenSize.height/20); 
		button.setFont(normal);


		//this is literally setting it to no color, but it makes
		// the code more stable so i'm leaving it in
		screen.win.setBackground(new Color(0,0,0,0));
		screen.win.setSize(screenSize);
		screen.win.setLocation(0, 0);
		screen.win.add(text);
		screen.win.setVisible(true);
		screen.win.add(button);
		screen.win.setVisible(true);



		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button) {
					//TODO send player to create pet
					screen.win.setVisible(false);
					screen.win.dispose();
				}
				

			}
		});
		
	}
	

	public static void initJump(Pet myPet) {

		//TODO fix me
		//Chaning everything from the PET into a string so I can pass it into the main 
		//method of JUMP where I turn it back from a string to it's initial type
		//JUMP2 AND JUMP 3 DON'T WORK RN!!!! 
		//GET RID OF PET PARAMETER IN MAIN METHOD 
		String args[] = {String.valueOf(myPet.getAge()), myPet.getGender()};
		StartScreen screen = new StartScreen();

		JLabel text = new JLabel("<html> <br><br><br> Please select which level you'd like to play</html>");
		JLabel text2 = new JLabel("<html> Goal: <br> Reach the end without hitting any walls<br><br>Controls: <br>w: Up <br>s: Down</html>");
		
		text.setHorizontalAlignment(JTextField.CENTER);
		text.setVerticalAlignment(JLabel.TOP);
		text.setFont(bold);
		text2.setHorizontalAlignment(JTextField.CENTER);
		text2.setVerticalAlignment(JLabel.CENTER);
		text2.setFont(normal);

		screen.win.setBackground(myC0);
		screen.win.setSize(screenSize);
		screen.win.setLocation(0, 0);
		screen.win.add(text);
		screen.win.setVisible(true);
		screen.win.add(text2);
		screen.win.setVisible(true);

		JFrame frame = new JFrame();
		JButton button = new JButton("Start");
		button.setBounds(100, 150, 140, 40);
		JTextField textfield = new JTextField();
		textfield.setBounds(110, 100, 130, 30);
		JLabel label = new JLabel();
		label.setText("Please select 1, 2 or 3 to select the level");
		label.setBounds(10, 10, 1000, 100);

		
		screen.win.setVisible(true);

		// frame.add(label1);
		frame.add(textfield);
		frame.add(label);
		frame.add(button);
		frame.setSize(screenSize.width / 6, screenSize.height / 5);
		frame.setLocation(screenSize.width / 2, screenSize.height / 2);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = textfield.getText();
				if (text.equals("1")) {
					frame.setVisible(false);
					frame.dispose();
					screen.win.setVisible(false);
					screen.win.dispose();
					JUMP.myPet = myPet;
					JUMP.main(args);
				} else if (text.equals("2")) {
					frame.setVisible(false);
					frame.dispose();
					screen.win.setVisible(false);
					screen.win.dispose();
					JUMP2.main(args);
				} else if (text.equals("3")) {
					frame.setVisible(false);
					frame.dispose();
					screen.win.setVisible(false);
					screen.win.dispose();
					JUMP3.main(args);
				}

			}
		});
	}


}
