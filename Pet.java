package pet;

import java.util.ArrayList;
import java.util.List;

import store.StoreObjects;

public class Pet {
	
	public final int INV_SIZE = 25;
	
	private double age;
	private double health;
	private String name;
	private double level;
	private boolean isMale;
	private int points;
	private double hunger;
	private List<StoreObjects> inventory = new ArrayList<>();
	private int numItems;
	private boolean isDead;
	
	
	
	public Pet(int age, int health, String name, double level, boolean isMale,
			int points,double hunger, List<StoreObjects> inventory, int numItems, boolean isDead ) {
		
		this.age = age;
		this.health = health;
		this.name = name;
		this.level = level;
		this.isMale = isMale;
		this.points = points;
		this.hunger = hunger;
		this.inventory = inventory;
		this.numItems = numItems;
		this.isDead = isDead;
		
	}
	
	public Pet(String name, boolean isMale) {
		this.name = name;
		age = 0;
		health = 100;
		level = 0;
		points = 500;
		hunger = 100;
		this.isMale = isMale;
	}
	
	
	//age methods
	
	public void ageIncrease() {
		age++;
	}
	
	public double getAge() {
		return age;
	}
	
	
	//health methods
	
	public void healthDecrease(double decreaseAmt) {
		health = Math.max(health-decreaseAmt,0);
		isDead();
		
	}
	
	public void healthIncrease(double addAmt) {
		health = Math.min(health+addAmt, 100);
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
		level = Math.min(level+addAmt, 99);
		//win?? @ 99
	}
	
	//gender methods
	
	public void changeGender() {
		if (isMale){
			isMale = false;
		}
		else isMale = true;
	}
	
	//point methods
	
	public int getPoints() {
		return points;
	}
	
	public void addPoints(int addAmt) {
		//caps points at 999999
		points = Math.min(points+addAmt, 999999);
	}
	
	public void decreasePoints(int decreaseAmt) {
		points = Math.max(points-decreaseAmt, 0);
	}
	
	
	//hunger methods
	
	
	public double hunger() {
		return hunger;
	}
	
	public void addHunger(double addAmt) {
		hunger = Math.min(hunger+addAmt, 100);
	}
	
	public void decreaseHunger(double decreaseAmt) {
		hunger = Math.max(hunger-decreaseAmt, 0);
	}
	
	
	//inventory methods

	public List<StoreObjects> getInventory() {
		return inventory;
	}
	
	public void addInventory(StoreObjects item) {
		inventory.add(item);
		
	}
	
	public void removeInventory(StoreObjects item) {
		inventory.remove(item);
		
	}

	
	//numItems methods (not sure if we even need these) 
	
	public int getNumItems() {
		return numItems;
	}
	
	
	//isDead methods
	
	
	public boolean isDead() {
		if(health == 0) {
			isDead = true;
		}
		else { isDead = false; }
		
		return isDead;
	}
	
	

	
	

}
