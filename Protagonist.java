package Game1;

public class Protagonist extends LivingThing implements Action{

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
		giveDamage = (int)(Math.random() * level) + (health / 2); // random algorithm to determine attack intensity
		System.out.println("You inflict " + giveDamage + " damage");
		return giveDamage;
	}
	
	public Boolean checkHealth() {
		if (health <= 0) {
			alive = false;
		}
		else alive = true;
		return alive;
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
			}
			else {
				getDamage = getDamage / 2;
				System.out.println("But you try to dodge the attack! You only receive " + getDamage + " damage");
			}
		}
		else if (lastMove.equals("defend")) {
			getDamage -= getDamage / ((int)(Math.random() * 3) + 1);
			System.out.println("You defend the attack. You only receive " + getDamage + " damage.");
		}
		health -= getDamage;
		checkHealth();
		if (alive) System.out.println("Your health: " + getHealth());
		
	}

}
