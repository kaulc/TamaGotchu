package Game1;

public interface Action {

	public int act();
	public void defend();
	public void dodge();
	public int attack();
	public void getAttacked(int getDamage);
	
}
