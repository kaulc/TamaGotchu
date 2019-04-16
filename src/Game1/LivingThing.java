package Game1;

public abstract class LivingThing {
	protected int health;  // health is random # based on level
	protected int level;
	protected int giveDamage = 0;
	protected Boolean alive;
	protected String lastMove = "";
	
	// getters
	public int getHealth() {
		return health;
	}
		
	public int getLevel() {
		return level;
	}
		
}
