
						GamePlay.newProtagonist(myPet);
						//GamePlay.myPet.setPoints(myPet.getPoints());
						myPet.setPoints(GamePlay.getProtagonist().getPoints());
						//GamePlay.main(args); <-- gives null pointer exception
						
			
			}
		
		else {
			StoreObjects toBuy = shopInv[userInput];
			
			if(myPet.getPoints() <= toBuy.getPrice()) {
				System.out.println("Sorry ur a broke boi �\\_(UwU)_/�, come back for that item later");
				System.out.println("In the mean time, how about you buy something more in your range");
				Shop.showShop();
				continue;
			}
			
			else {
				System.out.println("Congrats, " + toBuy.getName() + " has been added to your inventory");
				myPet.addInventory(toBuy);
				myPet.decreasePoints(toBuy.getPrice());
				menu(myPet);
			}
			
		}

		}
		
		
	}

}
