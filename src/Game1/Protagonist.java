package Game1;

import java.util.Scanner;

public class Protagonist extends LivingThing implements FightingActions, Action {

	private int hunger;
	private int points;

	public Protagonist(int h, int l, int hu, int p) {
		health = h;
		level = l;
		hunger = hu;
		points = p;
		alive = true;
	}

	public void stats() {
		System.out.println("Health = " + health);
		System.out.println("Level = " + level);
		System.out.println("Hunger = " + hunger);
		System.out.println("Points = " + points);
	}

	// getters
	public int getHunger() {
		return hunger;
	}

	public int getPoints() {
		return points;
	}

	// actions
	public int act() {
		System.out.println("action");
		return -1;
	}

	public void defend() {
		System.out.println("You defended!");
		lastMove = "defend";
	}

	public void dodge() {
		System.out.println("You dodged!");
		lastMove = "dodge";
	}

	public int attack() {
		System.out.println("You attack!");
		lastMove = "attack";
		giveDamage = (int) (Math.random() * level) + (health / 2); // random algorithm to determine attack intensity
		System.out.println("You inflict " + giveDamage + " damage");
		return giveDamage;
	}

	public Boolean checkHealth() {
		if (health <= 0) {
			alive = false;
		} else
			alive = true;
		return alive;
	}

	// adds set amount of health to protagonist's health
	public void addHealth(int h) {
		health += h;
		System.out.println("Gained " + h + " health. ");
	}

	// adds set amount of points to protagonist's points
	public void addPoints(int pts) {
		points += pts;
		System.out.println("Gained " + pts + " points. ");
	}

	@Override
	public void getAttacked(int getDamage) {
		if (lastMove.equals("dodge")) {
			int dodgeChance = (int) (Math.random() * 3); // random int between 1->3

			// 2/3 chance that monster dodges attack
			// if dodgeChance is odd, dodge is successful
			if (dodgeChance % 2 == 1) {
				getDamage = 0;
				System.out.println("But you dodge the attack! You receive 0 damage");
			} else {
				getDamage = getDamage / 2;
				System.out.println("But you try to dodge the attack! You only receive " + getDamage + " damage");
			}
		} else if (lastMove.equals("defend")) {
			getDamage -= getDamage / ((int) (Math.random() * 3) + 1);
			System.out.println("You defend the attack. You only receive " + getDamage + " damage.");
		}
		health -= getDamage;
		checkHealth();
		if (alive)
			System.out.println("Your health: " + getHealth());

	}

	@Override
	public int turn() { // NOT USED
		Scanner sc = new Scanner(System.in);
		String tempAns = "z";

		System.out.print("\nYou can either go left, right, or forward. What do you choose? [l/r/f]");

		while (!tempAns.equals("l") && !tempAns.equals("r") && !tempAns.equals("f")) { // prompt user for proper input
			if (sc.hasNextLine()) {
				tempAns = sc.nextLine();
				tempAns = tempAns.toLowerCase();
			}
			if (tempAns.equals("l")) {
				System.out.println("You turn left and continue walking.");
				return -1;
			}
			if (tempAns.equals("r")) {
				System.out.println("You turn right and continue walking.");
				return 1;
			}
			if (tempAns.equals("f")) {
				System.out.println("You continue walking forward.");
				return 0;
			}
			if (!tempAns.equals("l") && !tempAns.equals("r") && !tempAns.equals("f")) {
				System.out.println("Press [l] to turn left, [r] to turn right, or [f] to go forward.");
			}
		}
		sc.close();
		return -999;
	}

	@Override
	public int chooseAction() {
		int choice = (int) (Math.random() * 7);
		// random selection of 3 or 4 actions to encounter in hallway
		// if choice == 1 --> encounter gem (apple) (points)
		// if choice == 2 --> encounter heart (health)
		// if choice == 3 --> encounter treasure chest
		// else (choice == 4, 5, 6) --> keep walking and turn
		return choice;
	}

}
