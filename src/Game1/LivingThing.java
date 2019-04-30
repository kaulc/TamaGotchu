package Game1;

public abstract class LivingThing {
	protected double health;  // health is random # based on level
	protected double level;
	protected int giveDamage = 0;
	protected Boolean alive;
	protected String lastMove = "";
	
	// getters
	public double getHealth() {
		return health;
	}
		
	public double getLevel() {
		return level;
	}
		
}
