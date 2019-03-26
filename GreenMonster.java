package Game1;

public class GreenMonster extends Monster{

	// monster with set stats
	public GreenMonster(int health, int level, String keyMove) {
		super(health, level, keyMove);
	}
	
	// monster with random stats
	public GreenMonster(int petLevel) {
		
		level = (int) (Math.random() * petLevel); // monster level is random number <= petLevel
		health = (int) ((Math.random() * 30) + 10);
		keyMove = keyMoves[(int) (Math.random() * 4)]; // chooses one of 4 possible keyMoves from set list
		alive = true;
	}
	
	public void introStats() {
		System.out.println("Your opponent is a green monster!");
		super.introStats();
	}


}
