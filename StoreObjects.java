package Store;

public class StoreObjects {


	public String name;
	public int price;
	public int health;
	public int hunger;
	

    public StoreObjects(String name, int price, int health, int hunger){
	      this.name = name;
	      this.price = price;
	      this.health = health;
	      this.hunger = hunger;
	}
	   

	public static void main(String[] args) {
		
		 StoreObjects[] shirts = new StoreObjects[5];
		 
		 shirts[0] = new StoreObjects("Green Shirt", 200, 0, 0);
		 shirts[1] = new StoreObjects("Blue Shirt", 200, 0 , 0);
		 shirts[2] = new StoreObjects("Red Shirt", 200, 0 , 0);
		 shirts[3] = new StoreObjects("Yellow Shirt", 200, 0 , 0);
		 shirts[4] = new StoreObjects("Gold Shirt", 1000, 0 , 0);
		 
		 
		 StoreObjects[] pants = new StoreObjects[5];
		 
		 pants[0] = new StoreObjects("Green Pants", 300, 0, 0);
		 pants[1] = new StoreObjects("Blue Pants", 300, 0 , 0);
		 pants[2] = new StoreObjects("Red Pants", 300, 0 , 0);
		 pants[3] = new StoreObjects("Yellow Pants", 300, 0 , 0);
		 pants[4] = new StoreObjects("Gold Pants", 1500, 0 , 0);
		 
		 StoreObjects[] shoes = new StoreObjects[5];
		 
		 shoes[0] = new StoreObjects("Nikes", 500, 0, 0);
		 shoes[1] = new StoreObjects("Adidas", 500, 0 , 0);
		 shoes[2] = new StoreObjects("Jordans", 750, 0 , 0);
		 shoes[3] = new StoreObjects("Vans", 300, 0 , 0);
		 shoes[4] = new StoreObjects("Yeezys", 1500, 0 , 0);
		 
		 StoreObjects[] food = new StoreObjects[5];
		 
		 food[0] = new StoreObjects("Cheese", 300, 75, 75);
		 food[1] = new StoreObjects("Beef", 300, 75, 75);
		 food[2] = new StoreObjects("Beans", 250, 70, 70);
		 food[3] = new StoreObjects("Soup", 100, 25, 25);
		 food[4] = new StoreObjects("Cake", 500, 100, 100);
		 
		 StoreObjects[] drinks = new StoreObjects[5];
		 
		 drinks[0] = new StoreObjects("Water", 50, 15, 15);
		 drinks[1] = new StoreObjects("Apple Juice", 100, 25 , 25);
		 drinks[2] = new StoreObjects("Orange Juice", 100, 25 , 25);
		 drinks[3] = new StoreObjects("Milk", 150, 40 , 40);
		 drinks[4] = new StoreObjects("Chocolate Milk", 500, 100 , 100);	
		 
		 StoreObjects[] potions = new StoreObjects[4];
		 
		 potions[0] = new StoreObjects("Mild Potion", 100, 25, 25);
		 potions[1] = new StoreObjects("Medium Potion", 200, 50 , 50);
		 potions[2] = new StoreObjects("Good Potion", 300, 75, 75);
		 potions[3] = new StoreObjects("Best Potion", 500, 100, 100);
		 
		 
		 
	 }
	
	
	
	
	
	
	
	
	
}
