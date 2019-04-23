package thePet;

import java.util.Arrays;

public class StoreObjects {


private String name;
private int price;
private int health;
private int hunger;

    public StoreObjects(String name, int price, int health, int hunger){
	      this.name = name;
	      this.price = price;
	      this.health = health;
	      this.hunger = hunger;
	}
    
    
	   

	public static void main(String[] args) {
	
		
		 
//		 items[0] = new StoreObjects("Green Shirt", 200, 0, 0);
//		 items[1] = new StoreObjects("Blue Shirt", 200, 0 , 0);
//		 items[2] = new StoreObjects("Red Shirt", 200, 0 , 0);
//		 items[3] = new StoreObjects("Yellow Shirt", 200, 0 , 0);
//		 items[4] = new StoreObjects("Gold Shirt", 1000, 0 , 0);
//		 
//		 
//		 items[5] = new StoreObjects("Green items", 300, 0, 0);
//		 items[6] = new StoreObjects("Blue items", 300, 0 , 0);
//		 items[7] = new StoreObjects("Red items", 300, 0 , 0);
//		 items[8] = new StoreObjects("Yellow items", 300, 0 , 0);
//		 items[9] = new StoreObjects("Gold items", 1500, 0 , 0);
//		 
//		 
//		 items[10] = new StoreObjects("Nikes", 500, 0, 0);
//		 items[11] = new StoreObjects("Adidas", 500, 0 , 0);
//		 items[12] = new StoreObjects("Jordans", 750, 0 , 0);
//		 items[13] = new StoreObjects("Vans", 300, 0 , 0);
//		 items[14] = new StoreObjects("Yeezys", 1500, 0 , 0);
//		 
//		 
//		 items[15] = new StoreObjects("Cheese", 300, 75, 75);
//		 items[16] = new StoreObjects("Beef", 300, 75, 75);
//		 items[17] = new StoreObjects("Beans", 250, 70, 70);
//		 items[18] = new StoreObjects("Soup", 100, 25, 25);
//		 items[19] = new StoreObjects("Cake", 500, 100, 100);
//		 
//		 
//		 items[20] = new StoreObjects("Water", 50, 15, 15);
//		 items[21] = new StoreObjects("Apple Juice", 100, 25 , 25);
//		 items[22] = new StoreObjects("Orange Juice", 100, 25 , 25);
//		 items[23] = new StoreObjects("Milk", 150, 40 , 40);
//		 items[24] = new StoreObjects("Chocolate Milk", 500, 100 , 100);	
//		 
//		 
//		 items[25] = new StoreObjects("Mild Potion", 100, 25, 25);
//		 items[26] = new StoreObjects("Medium Potion", 200, 50 , 50);
//		 items[27] = new StoreObjects("Good Potion", 300, 75, 75);
//		 items[28] = new StoreObjects("Best Potion", 500, 100, 100);
//		
		
		 
	 }
	
	
//	public StoreObjects getItem(int shopInput) {
//		return items[shopInput];
//	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
		
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getHunger() {
		return hunger;
	}
	
	public String toString() {
		//String toRet = getName() + getPrice() + getHealth() + getHunger();
		
		String toRet = String.format("%-15s %-6d %-6d %-6d", getName(), getPrice(), getHealth(), getHunger());
		
		return toRet;
		
	}
	
	public static StoreObjects[] populateStore() {
		
		StoreObjects[] items = new StoreObjects[29];
		
		 items[0] = new StoreObjects("Green Shirt", 200, 0, 0);
		 items[1] = new StoreObjects("Blue Shirt", 200, 0 , 0);
		 items[2] = new StoreObjects("Red Shirt", 200, 0 , 0);
		 items[3] = new StoreObjects("Yellow Shirt", 200, 0 , 0);
		 items[4] = new StoreObjects("Gold Shirt", 1000, 0 , 0);
		 
		 
		 items[5] = new StoreObjects("Green items", 300, 0, 0);
		 items[6] = new StoreObjects("Blue items", 300, 0 , 0);
		 items[7] = new StoreObjects("Red items", 300, 0 , 0);
		 items[8] = new StoreObjects("Yellow items", 300, 0 , 0);
		 items[9] = new StoreObjects("Gold items", 1500, 0 , 0);
		 
		 
		 items[10] = new StoreObjects("Nikes", 500, 0, 0);
		 items[11] = new StoreObjects("Adidas", 500, 0 , 0);
		 items[12] = new StoreObjects("Jordans", 750, 0 , 0);
		 items[13] = new StoreObjects("Vans", 300, 0 , 0);
		 items[14] = new StoreObjects("Yeezys", 1500, 0 , 0);
		 
		 
		 items[15] = new StoreObjects("Cheese", 300, 75, 75);
		 items[16] = new StoreObjects("Beef", 300, 75, 75);
		 items[17] = new StoreObjects("Beans", 250, 70, 70);
		 items[18] = new StoreObjects("Soup", 100, 25, 25);
		 items[19] = new StoreObjects("Cake", 500, 100, 100);
		 
		 
		 items[20] = new StoreObjects("Water", 50, 15, 15);
		 items[21] = new StoreObjects("Apple Juice", 100, 25 , 25);
		 items[22] = new StoreObjects("Orange Juice", 100, 25 , 25);
		 items[23] = new StoreObjects("Milk", 150, 40 , 40);
		 items[24] = new StoreObjects("Chocolate Milk", 500, 100 , 100);	
		 
		 
		 items[25] = new StoreObjects("Mild Potion", 100, 25, 25);
		 items[26] = new StoreObjects("Medium Potion", 200, 50 , 50);
		 items[27] = new StoreObjects("Good Potion", 300, 75, 75);
		 items[28] = new StoreObjects("Best Potion", 500, 100, 100);
		
		
		return items;
	}
	
	//I should only be passing in valid objects, so it should be fine to not have a catch
	//This is used in the JUMP classes to pass in the Pet using the main String[] args

	public static StoreObjects findObj(String in) {
		
		StoreObjects[] store = populateStore();
		
		for (int i =0; i<store.length; i++) {
			
			StoreObjects check = store[i];
			if(check.getName().equals(in)) {
				return store[i];
				
			}
		}
		return null;
		
		
	}
	
	
	
	
}
