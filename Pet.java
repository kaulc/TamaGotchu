package thePet;

	import java.util.ArrayList;
	import java.util.List;

	public class Pet {
		
		public final int INV_SIZE = 25;
		
		private double age;
		private double health;
		private String name;
		private String gender;
		private double level;
		private int points;
		private double hunger;
		public List<StoreObjects> inventory = new ArrayList<>();
		private boolean isDead;
		
		
		
		public Pet(int age, int health, String name, double level, String gender,
				int points,double hunger, List<StoreObjects> inventory, int numItems, boolean isDead ) {
			
			this.age = age;
			this.health = health;
			this.name = name;
			this.level = level;
			this.gender = gender;
			this.points = points;
			this.hunger = hunger;
			this.inventory = inventory;
			this.isDead = isDead;
			
		}
		
		public Pet(String name, String gender) {
			this.name = name;
			age = 0;
			health = 100;
			level = 0;
			points = 500;
			hunger = 100;
			this.gender = gender;
		}
		
		
		//age methods
		
		public void ageIncrease() {
			age++;
		}
		
		public double getAge() {
			return age;
		}
		
		
		//health methods
		
		public void removeHealth(double decreaseAmt) {
			health = Math.max(health - decreaseAmt, 0);
			isDead();
		}
		
		public void addHealth(double addAmt) {
			health = Math.min(health + addAmt, 100);
		}
		
		public void setHealth(double h) {
			health = h;
		}
		
		public double getHealth() {
			return health;
		}
		
		//name methods
		
		public String getName() {
			return name;
		}
		
		
		public void nameChange(String newName) {
			this.name = newName;
		}
		
		//level methods
		
		public double getLevel() {
			return level;
		}
		
		public void increaseLevel(double addAmt) {
			//caps lvl at 99
			level = Math.min(level + addAmt, 99);
		}
		
		//gender methods
		
		public void changeGender() {
			if (gender == "F") {
				gender = "Female";
			}
			else gender = "Male";
		}
		
		//point methods
		
		public int getPoints() {
			return points;
		}
		
		public void addPoints(int addAmt) {
			//caps points at 999999
			points = Math.min(points + addAmt, 999999);
		}
		
		public void decreasePoints(int decreaseAmt) {
			points = Math.max(points - decreaseAmt, 0);
		}
		
		
		//hunger methods
		
		
		public double getHunger() {
			return hunger;
		}
		
		public void addHunger(double addAmt) {
			hunger = Math.min(hunger + addAmt, 100);
		}
		
		public void decreaseHunger(double decreaseAmt) {
			hunger = Math.max(hunger - decreaseAmt, 0);
		}
		
		public void setHunger(double setAmt) {
			hunger =  Math.min(setAmt, 100);
		}
		
		
		//inventory methods
		public List<StoreObjects> getInventory() {
			return inventory;
			
		}
		
		
		public void printInventory() {
			for(int i =0; i< inventory.size(); i++ ) {
				StoreObjects s = inventory.get(i);
				String a = s.toString();
				System.out.print(i + " "+ a);
				
			if (i % 4 == 0) {
				System.out.println();
				}
			}
		}
		
		public void addInventory(StoreObjects item) {
			inventory.add(item);
		}
		
		public void removeInventory(StoreObjects item) {
			inventory.remove(item);
		}

		
		//isDead methods
		
		
		public boolean isDead() {
			if(health == 0) {
				isDead = true;
			}
			else { isDead = false; }
			
			return isDead;
		}

		public String getGender() {
			return gender;
		}
		
		
	
	
}
