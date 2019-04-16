package Game1;

public abstract class Monster extends LivingThing implements FightingActions {

	protected String keyMove;
	protected String[] keyMoves = {"Scissorkick", "Megapunch", "Jabbyjab", "Superslap"};
	protected String[] moves = {"kick", "punch", "jab", "slap"};
	
	public Monster(int health, int level, String keyMove) {
		this.health = health;
		this.level = level;
		this.keyMove = keyMove;
		alive = true;
	}
	
	public Monster() {
	}
	
	public void getKeyMove() {
		System.out.println("Key Move: " + keyMove);
	}
	
	public void introStats() {
		System.out.println("Monster health: " + health);
		System.out.println("Monster key move: " + keyMove);
	}
	
	@Override
	public String toString() {
		return keyMove;
		
	}
	
	@Override
	public int act() {
		int chooseAct = (int)(Math.random() * 3);
		if (chooseAct == 0) defend();
		else if (chooseAct == 1) dodge();
		else if (chooseAct == 2) attack();
		return chooseAct;

	}
	
	@Override
	public void defend() {
		System.out.println("Monster defended");
		lastMove = "defend";
		
	}

	@Override
	public void dodge() {
		System.out.println("Monster dodged");
		lastMove = "dodge";
		
	}

	@Override
	public int attack() {
		int keyMoveTF = (int)(Math.random() * 2);
		
		if (keyMoveTF == 1) {
			System.out.println("Monster attacks with key move!");
			giveDamage = 2 * ((int)(Math.random() * level) + (health / 3)) + 14; // random algorithm to determine attack intensity - doubled for key move
		}
		else {
			System.out.println("Monster attacks");
			giveDamage = (int)(Math.random() * level) + (health / 3); // random algorithm to determine attack intensity
		}
		
		System.out.println("Monster inflicts " + giveDamage + " damage");
		return giveDamage;
	}


	@Override
	public void getAttacked(int getDamage) {
		if (lastMove.equals("dodge")) {
			int dodgeChance = (int) (Math.random() * 5); // random int between 0->4
			
			// 2/5 chance that monster dodges attack
			// if dodgeChance is odd, dodge is successful
			if (dodgeChance % 2 == 1) {
				getDamage = 0;
				System.out.println("But Monster dodges the attack! Monster receives 0 damage");
			}
			else {
				getDamage = getDamage / 2;
				System.out.println("But Monster tries to dodges the attack! Monster only receives " + getDamage + " damage");
			}
		}
		else if (lastMove.equals("defend")) {
			getDamage -= getDamage / ((int)(Math.random() * 3) + 1);
			System.out.println("Monster defends the attack. Monster receives " + getDamage + " damage.");
		}
		health -= getDamage;
		if (checkHealth()) System.out.println("Monster health: " + super.getHealth());
		
		
	}
	
	public Boolean checkHealth() {
		if (health <= 0) {
			alive = false;
		}
		else alive = true;
		return alive;
	}
	
	

}
