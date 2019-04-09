package Game1;

import java.util.Scanner;

public class GamePlay {

	static Protagonist p = new Protagonist(50, 3, 15, 4000); // STATS WILL BE IMPORTED FROM OTHER PET CLASSES
	static Boolean play = true;
	static Scanner sc = new Scanner(System.in);
	
	public Boolean getPlay() {
		return play;
	}
	
	public void setPlay(Boolean bool) {
		play = bool;
	}
	
	public Protagonist getProtagonist() {
		return p;
	}
	
	public void setProtagonist(Protagonist pro) {
		p = pro;
	}
	
	
	public static void main(String[] args) {
		
		Contralar controller = new Contralar();
		
		String tempAns = "";
		int numSteps = 0; // step = # actions taken to find one monster
		int numRounds = 0; // round = # monsters fought to reach final monster
		int stepCounter = 0;
		int roundCounter = 0;

		// start screen text

		System.out.println("Welcome to Castle Dash");
		System.out.println("You find yourself at the entrance of a castle. You read a sign that states: ");
		System.out.println("- In this castle lies a room of riches. If you find it, you keep it. Enter at your risk.");
		System.out.println("Press [p] to enter the castle and start playing, [s] for stats, or [e] to exit.");
		
		/* NOT NEEDED WHEN WE USE BUTTONS
		if (sc.hasNextLine())
			tempAns = sc.nextLine();
		tempAns = tempAns.toLowerCase();

		while (!tempAns.equals("p")) {
			if (!tempAns.equals("p") && !tempAns.equals("s") && !tempAns.equals("e")) {
				System.out.println("Press [p] to enter the castle and start playing, [s] for stats, or [e] to exit.");
			}
			if (tempAns.equals("e")) {
				System.out.println("Okay thanks for playing, bye");
				break;
			}
			if (tempAns.equals("s")) {
				p.stats();
			}
			if (sc.hasNextLine())
				tempAns = sc.nextLine();
		}

		if (tempAns.equals("p")) {*/
		
		if (play) {

			System.out.println("You enter the castle.");
 
			stepCounter = 0;
			roundCounter = 0;

			numRounds = (int) (Math.random() * (numRounds * 5) + 3); // rounds will be randomly generated
			//System.out.println("TESTING: numRounds = " + numRounds);
			roundCounter = 0;
			
			while (roundCounter < numRounds) {
				numSteps = (int) ((Math.random() * numRounds * 2) + roundCounter + 1); // generates num steps for next round based on current round
				stepCounter = 0;																
				//System.out.println("TESTING: numSteps = " + numSteps);
				

				while (stepCounter < numSteps) {
					System.out.print("Now you can either go left, right, or forward. What do you choose? [l/r/f]");
					System.out.println();
					if (sc.hasNextLine()) {
						tempAns = sc.nextLine();
						if (tempAns.equals("l"))
							System.out.println("You turn left and continue walking.");
						if (tempAns.equals("r"))
							System.out.println("You turn right and continue walking.");
						if (tempAns.equals("f"))
							System.out.println("You continue walking forward.");
					}
					tempAns = tempAns.toLowerCase();
					stepCounter++;
				}
			
			
				
				System.out.println("\nOh no! You face a monster. Defeat it to continue your journey in the castle!\n ");
				fightMonster(generateNewMonster(p.getLevel()));
				
				roundCounter++;
			}
			
			System.out.println("Good job! You have successfully defeated all the monsters in the castle.");
			System.out.println("You continue walking forward and reach the end of the hallway, where there is a door that has a sign: ");
			System.out.println("- Finders keepers ");
			System.out.println("Press any key to open the door and claim your riches!");
			
			if (sc.hasNextLine()) {
				System.out.println("You open the door and there lies a room with piles and piles of gold and treasure. "
						+ "You walk towards the treasures in awe with your arms wide.");
				System.out.println("But wait! Suddenly, the door slams shut behind you and you realize you are not alone in the room. You turn around...");
				
				System.out.println("\n\nIt's the final monster!! Defeat it to finally claim your riches! (boss fight asldfj)");
				fightMonster(generateBossMonster(p.getLevel()));
				// generate boss monster and fight him - hard fight
			}
			
			sc.close();

		}
	}
	
	private static Monster generateBossMonster(int petlevel) {
		return new BossMonster(petlevel);
	}

	private static Monster generateNewMonster(int petlevel) {

		// random number generator to choose which monster to randomly create
		int whichMons = (int) (Math.random() * 3);
		if (whichMons == 0)
			return new GreenMonster(petlevel);
		else if (whichMons == 1)
			return new RedMonster(petlevel);
		else
			return new BlueMonster(petlevel);
	}

	private static Boolean fightMonster(Monster m) {
		
		System.out.println("~~~");
		int petTurn = (int) (Math.random() * 2); // true or false, randomizes who starts fighting first
		String tempAns = "";

		m.introStats();

		while (p.checkHealth() == true && m.checkHealth() == true) { // fight till someone dies
			if (petTurn == 1) {
				System.out.println("\nIt's your turn!");
				System.out.println("Press [j] to defend, [i] to dodge, [l] to attack, or [s] for your stats");

				tempAns = "x";

				while (!tempAns.equals("j") && !tempAns.equals("i") && !tempAns.equals("l")) { // prompt user for proper
																								// input
					tempAns = sc.next();
					tempAns = tempAns.toLowerCase().trim();
					
					if (tempAns.equals("j")) {
						p.defend();
						break;
					}
					if (tempAns.equals("i")) {
						p.dodge();
						break;
					}
					if (tempAns.equals("l")) {
						m.getAttacked(p.attack());
						break;
					}
					if (tempAns.equals("s")) {
						p.stats();
					}
					if (!tempAns.equals("j") && !tempAns.equals("i") && !tempAns.equals("l")) {
						System.out.println("Press [j] to defend, [i] to dodge, [l] to attack, or [s] for your stats");
					}
				}
				if (p.checkHealth() == false || m.checkHealth() == false) // if someone dies, break
					break;
				petTurn = 0;
			}
			if (petTurn == 0) {
				System.out.println();
				System.out.println("It's the monster's turn!");
				if (m.act() == 2)
					p.getAttacked(m.giveDamage);

				petTurn = 1;
				if (p.checkHealth() == false || m.checkHealth() == false) // if someone dies, break
					break;
			}

		}

		if (p.checkHealth() == false) {
			System.out.println("\nYou died :( Come back and try again later");
			play = false;
			System.exit(0);
		} else if (m.checkHealth() == false) {
			System.out.println("\nYay, Monster died! You can continue your journey into the castle");
			play = true;
		}
		System.out.println("~~~");
		return play;

	}
	
	
	
	

}
