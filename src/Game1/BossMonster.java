package Game1;

public class BossMonster extends Monster{

	// monster with set stats
	public BossMonster(int health, int level, String keyMove) {
		super(health, level, keyMove);
	}
		
	// monster with random stats
	public BossMonster(double petlevel) {
		level = (int) (Math.random() * petlevel) + (petlevel * 2 / 3); // monster level is random number close to petLevel
		health = (int) ((Math.random() * 110) + 50);
		keyMove = keyMoves[(int) (Math.random() * 4)]; // chooses one of 4 possible keyMoves from set list
		alive = true;
		boss = true;
	}
	
	public void introStats() {
		System.out.println("Your opponent is the FINAL BOSS MONSTER!");
		super.introStats();
	}

	@Override
	public int attack() {
		int keyMoveTF = (int)(Math.random() * 2);
		
		if (keyMoveTF == 1) {
			System.out.println("Monster attacks with key move!");
			giveDamage = (int) (1 * ((int)(Math.random() * level) + (health * 1 / 5)) / 3); // random algorithm to determine attack intensity - doubled for key move
		}
		else {
			System.out.println("Monster attacks");
			giveDamage = (int) ((int)(Math.random() * level) + (health * 1 / 5)); // random algorithm to determine attack intensity
		}
		
		System.out.println("Monster inflicts " + giveDamage + " damage");
		return giveDamage;
	}
	
	@Override
	public void getAttacked(int getDamage) {
		if (lastMove.equals("dodge")) {
			int dodgeChance = (int) (Math.random() * 7); // random int between 0->6
			
			// 3/7 chance that monster dodges attack
			// if dodgeChance is odd, dodge is successful
			if (dodgeChance % 2 == 1) {
				getDamage = 0;
				System.out.println("But Monster dodges the attack! Monster receives 0 damage");
			}
			else {
				getDamage = getDamage / 3;
				System.out.println("But Monster tries to dodges the attack! Monster only receives " + getDamage + " damage");
			}
		}
		else if (lastMove.equals("defend")) {
			getDamage -= getDamage / ((int)(Math.random() * 4) + 1);
			System.out.println("Monster defends the attack. Monster receives " + getDamage + " damage.");
		}
		health -= getDamage;
		if (checkHealth()) System.out.println("Monster health: " + super.getHealth());
		
		
	}
	
}
