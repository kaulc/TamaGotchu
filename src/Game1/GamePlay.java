package Game1;

import java.util.Scanner;

import run.MainMenu;
import thePet.Pet;

public class GamePlay {
	
	public static Pet mypet;

	//TODO Figure out where to call the menu class after the game is over
	
	//FIXME use the passed in Pet to set these values
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

	public static void main(String[] args, Pet myPet) {

		// Contralar controller = new Contralar();

		String tempAns = "";
		int numSteps = 0; // step = # actions taken to find one monster
		int numRounds = 0; // round = # monsters fought to reach final monster
		int stepCounter = 0;
		int roundCounter = 0;
		int choice = 0;

		// start screen text

		System.out.println("Welcome to Castle Dash");
		System.out.println("You find yourself at the entrance of a castle. You read a sign that states: ");
		System.out.println("- In this castle lies a room of riches. If you find it, you keep it. Enter at your risk.");
		System.out.println("Press [a] to enter the castle and start playing, [s] for stats, or [d] to exit.");

		if (sc.hasNextLine())
			tempAns = sc.nextLine();
		tempAns = tempAns.toLowerCase();
		while (!tempAns.equals("a")) {
			if (!tempAns.equals("a") && !tempAns.equals("s") && !tempAns.equals("d")) {
				System.out.println("Press [a] to enter the castle and start playing, [s] for stats, or [d] to exit.");
			}
			if (tempAns.equals("d")) {
				System.out.println("Okay thanks for playing, bye");
				play = false;
				break;
			}
			if (tempAns.equals("s")) {
				p.stats();
				System.out.println("Press [a] to enter the castle and start playing, [s] for stats, or [d] to exit.");
			}
			if (tempAns.equals("a")) {
				play = true;
			}
			if (sc.hasNextLine())
				tempAns = sc.nextLine();
		}

		if (play) {

			System.out.println("You enter the castle.");

			stepCounter = 0;
			roundCounter = 0;

			numRounds = (int) (Math.random() * (numRounds * 5) + 3); // rounds will be randomly generated
			// System.out.println("TESTING: numRounds = " + numRounds);
			roundCounter = 0;

			while (roundCounter < numRounds && play) {

				numSteps = (int) ((Math.random() * numRounds * 2) + roundCounter + 1); // generates num steps for
																						// next round based on
																						// current round
				stepCounter = 0;
				// System.out.println("TESTING: numSteps = " + numSteps);

				while (stepCounter < numSteps && play) {
					System.out.println();
					System.out.println("choice: " + choice);
					// 1. apple
					if (choice == 1) {
						System.out.println("You encounter an apple! Pick it up? [d] for yes, [f] for no");

						// IF STATEMENT FROM TEST BUTTONS
						if (sc.hasNextLine())
							tempAns = sc.nextLine();
						if (tempAns.equals("d")) {
							int rand = (int) (Math.random() * 3);
							if (rand == 0 || rand == 1) {
								System.out.println("Mm.. it's a tasty apple. ");
								p.addPoints(10);
							} else if (tempAns.equals("f")) {
								System.out.println("Eww.. the apple is way too sour. ");
								p.addPoints(-10);
							}
						}
						else if (tempAns.equals("f")) System.out.println("You walk away from the apple.");
						choice = 4;
					} else if (choice == 2) {
						System.out.println("You encounter a heart! <3");
						p.addHealth(10);
						choice = 4;
					} else if (choice == 3) {
						System.out.println("You encounter a treasure chest!! Open it? [d] for yes, [f] for no");
						if (sc.hasNextLine())
							tempAns = sc.nextLine();
						if (tempAns.equals("d")) {
							System.out.println("You open it...");
							int temp = (int) (Math.random() * 4);
							if (temp == 0) {
								break;
							}
							else if (temp == 1) {
								System.out.println("<3 It's a chest full of hearts!! <3");
								p.addHealth(50);
							}
							else if (temp == 2) {
								
								System.out.println("It's a chest full of apples :o Eat them? [d] for yes, [f] for no");
								if (sc.hasNextLine())
									tempAns = sc.nextLine();
								if (tempAns.equals("d")) {
									int rand = (int) (Math.random() * 3);
									if (rand == 0 || rand == 1) {
										System.out.println("Mm.. they are tasty apples. ");
										p.addPoints(50);
									} else if (tempAns.equals("f")) {
										System.out.println("Eww.. the apples are way too sour. ");
										p.addPoints(-50);
									}
								}
								else if (tempAns.equals("f")) System.out.println("You walk away from the apples.");
								
							}
							else if (temp == 3) {
								System.out.println("It is empty :/");
							}
						}
						else if (tempAns.equals("f")) {
							System.out.println("You decide not to open it and walk away.");
						}
						choice = 4;
					}
					else {

						System.out.print("asNow you can either go left, right, or forward. What do you choose? [s/d/f]");
						System.out.println();

						/////
						if (sc.hasNextLine()) {
							tempAns = sc.nextLine();
							if (tempAns.equals("s"))
								System.out.println("You turn left and continue walking.");
							if (tempAns.equals("d"))
								System.out.println("You turn right and continue walking.");
							if (tempAns.equals("f"))
								System.out.println("You continue walking forward.");
							tempAns = tempAns.toLowerCase();
							stepCounter++;
							choice = p.chooseAction();
						}
						/////
						
					}
				}

				System.out.println("\nOh no! You face a monster. Defeat it to continue your journey in the castle!\n ");
				fightMonster(generateNewMonster(p.getLevel()));
				choice = 4;

				roundCounter++;
			}
		}

		System.out.println("Good job! You have successfully defeated all the monsters in the castle.");
		System.out.println(
				"You continue walking forward and reach the end of the hallway, where there is a door that has a sign: ");
		System.out.println("- Finders keepers ");
		System.out.println("Press any key to open the door and claim your riches!");

		if (sc.hasNextLine()) {
			System.out.println();
			System.out.println("You open the door and there lies a room with piles and piles of gold and treasure. "
					+ "You walk towards the treasures in awe with your arms wide.");
			System.out.println(
					"But wait! Suddenly, the door slams shut behind you and you realize you are not alone in the room. You turn around...");

			System.out.println(
					"\n\nIt's the final monster!! Defeat it to finally claim your riches!");
			fightMonster(generateBossMonster(p.getLevel()));
			// generate boss monster and fight him - hard fight
		}

		sc.close();
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
				System.out.println("Press [s] to defend, [d] to dodge, [f] to attack, or [a] for your stats");

				tempAns = "x";

				while (!tempAns.equals("s") && !tempAns.equals("d") && !tempAns.equals("f")) { // prompt user for proper
																								// input
					tempAns = sc.next();
					tempAns = tempAns.toLowerCase().trim();

					////
					if (tempAns.equals("s")) { // CHANGE TO NUMBERS RETURNED FROM TEST BUTTONS
						p.defend();
						break;
					}
					if (tempAns.equals("d")) {
						p.dodge();
						break;
					}
					if (tempAns.equals("f")) {
						m.getAttacked(p.attack());
						break;
					}
					if (tempAns.equals("a")) {
						p.stats();
					}
					if (!tempAns.equals("s") && !tempAns.equals("d") && !tempAns.equals("f")) {
						System.out.println("Press [s] to defend, [d] to dodge, [f] to attack, or [a] for your stats");
					}
					////
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
			//MainMenu.menu(myPet);
		} else if (m.checkHealth() == false) {
			System.out.println("\nYay, Monster died! You can continue your journey into the castle");
			play = true;
		}
		System.out.println("~~~");
		return play;

	}

}
