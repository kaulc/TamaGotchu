package pro;

import processing.core.PApplet;

public class JUMP extends PApplet{

	
	public static void main(String args[]) {
		
		PApplet.main("pro.JUMP");
		
		
	}
	
	
	
	public void settings() {
		size(1024, 768);
	}
	
	public void setup() {
		  stroke(255);
		  focused = true;
		  background(0);
	}
	
	
	int px = 0;
	int py = height/2;
	int i =0;
	int fat = 25;
	Player player = new Player(px, py, fat, fat);

	  
	 
	
	public void draw() {
		  background(0);
		  
		  
		  
		  
		  fill(197,179,88);
		  Player player = new Player(px, py, fat, fat);
		  player.draw();
		    
		 //bottom walls
		   for(i=100; i<width; i +=500) {
		    fill(200,0,200);
		    Wall bot = new Wall(i, height, fat, -height/4);
		    bot.draw();
		    
		    if(hitTest(player, bot)) {
		      //TODO exit and crash
		      crashAndBurn();
		    }
		  }
		  
		  
		 //top walls
		  for(i = 200; i<width; i += 350) {
		    fill(200,0,200);
		    
		   Wall top= new Wall(i, 0, fat, height/4);
		    top.draw();
		    if(hitTest(player, top)) {
		      //TODO exit and crash
		      crashAndBurn();
		    }
		  
		  }
		  
		 //middle walls
		  for(i = 150; i<width; i+= 400) {
		    
		    Wall mid = new Wall(i, height/2, fat, height/7);
		    mid.draw();
		    
		    if(hitTest(player, mid)) {
		      //TODO exit and crash
		      crashAndBurn();
		    }
		    
		  }
		  
		  
		    Wall rand = new Wall(255, height/2, fat, height/4);
		  Wall rand2 = new Wall(500, height/6, fat, height/3);
		  rand.draw();
		  rand2.draw();
		  
		  if(hitTest(player, rand) || hitTest(player, rand2)) {
		    //TODO exit and crash
		    crashAndBurn();
		  }

		  //Character
		  


		  


		/**println(player.getPosx());
		println("^^^^^^");
		println(player.getPosy());
		 **/
		 px++;

		if(px >= width) {
		  winnerWinner();
		}
	}
	
	
	
	class Entity {
		  
		  int posx,posy,w,h;
		  
		  boolean hitTest(Entity e) {
		     return(e.posx<this.posx+this.w && e.posx+e.w>this.posx && e.posy<this.posy+this.h &&
		     e.posy+e.h>this.posy);
		  }
		  
		}


		class Player extends Entity {
		  
		  Player(int x, int y , int w, int h) {
		    this.posx = x;
		    this.posy = y;
		    this.w = w;
		    this.h = h;
		    
		  }
		  
		  void draw() {
		    rect(posx, posy, w, h);
		  }
		  
		  int getPosx() {
		    return posx;
		  }
		  
		  int getPosy() {
		    return posy;
		  }
		  
		}


		class Wall extends Entity {
		  
		  Wall(int x, int y, int w, int h) {
		    this.posx = x;
		    this.posy = y;
		    this.w = w;
		    this.h = h;
		    
		  }
		  
		  void draw() {
		    rect(posx, posy, w, h); 
		    
		  }
		}
		    
		    
		public void keyPressed() {
			  //moves up
			  if(key == 'w') {
			    py-=10;
			    if(py<0){
			      py=0;
			    }
			  }
			  //moves down
			  if(key == 's') {
			    py+=10;
			    if(py > height-fat){
			      py = height-fat;
			    }
			      
			  }
			  

			}

			void crashAndBurn() {
			  println("YOU LOSE");
			  exit();
			}

			void winnerWinner() {
			  println("YOU WIN");
			  exit();
			}
			    
			    
			boolean hitTest(Entity e, Entity a) {
			     return(e.posx<a.posx+a.w &&
			     e.posx + e.w > a.posx && 
			     e.posy < a.posy + a.h &&
			     e.posy + e.h > a.posy);
			     
			  }
			    		
	
}
