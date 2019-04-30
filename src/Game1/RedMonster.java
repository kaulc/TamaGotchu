package Game1;

public class RedMonster extends Monster{

	// monster with set stats
	public RedMonster(int health, int level, String keyMove) {
		super(health, level, keyMove);
	}

	// monster with random stats
	public RedMonster(double petlevel) {

		level = (int) (Math.random() * petlevel); // monster level is random number <= petLevel
		health = (int) ((Math.random() * 40) + 15);
		keyMove = keyMoves[(int) (Math.random() * 4)]; // chooses one of 4 possible keyMoves from set list
		alive = true;
	}

	public void introStats() {
		System.out.println("Your opponent is a red monster!");
		super.introStats();
	}

}
