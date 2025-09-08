import java.util.Scanner;  //may be necessary for input

import javax.swing.JOptionPane;  //may be necessary for input

import kareltherobot.*;

public class Driver implements Directions {
// declared here so it is visible in all the methods!! 
// It will be assigned a value in the getInfo method
	private static Robot roomba; 


	// You will add very many variables!!

	
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		Driver d = new Driver();
int area = 1;
int pile_number = 0;
int beeper_number = 0;
int largest_pile = 0;
int idv_pile = 0;

  /**
	 * This section of code gets info from the user in the following order: 1. Ask the user
	 * which world file they wish to process. Right now, that world file name is
	 * hardcoded in. 2. Ask the user for the starting location and direction of the
	 * Robot. A new Robot should be constructed and assigned to the global
	 * (instance) variable named roomba that is declared on line 10.
	 * 
	 * An inelegant way to interact with the user is via the console, using
	 * System.out.println and a Scanner that scans System.in (input from the
	 * console). A more elegant way to get user input might include using a
	 * JOptionPane.
	 */
	Scanner WorldScanner = new Scanner(System.in);
	Scanner y_coordScanner = new Scanner(System.in);
	Scanner x_coordScanner = new Scanner(System.in);
//   Scanner directionScanner = new Scanner(System.in);

	
	System.out.print("Enter the y-coord: ");
   String y_coord = y_coordScanner.nextLine();

   System.out.print("Enter the x-coord: ");
   String x_coord = x_coordScanner.nextLine();

   System.out.print("Enter the world: ");
   String world = WorldScanner.nextLine();

//   System.out.print("Enter the direction: ");
//   String directionInput = y_coordScanner.nextLine();
   
   int y_coordInteger = Integer.parseInt(y_coord);
   int x_coordInteger = Integer.parseInt(x_coord);



	//right here
   	World.readWorld(world);
    World.setVisible(true);
	World.setDelay(1);


	Robot r = new Robot(y_coordInteger,x_coordInteger,East,0);
    


	
	 
    


	/** This section will have all the logic that takes the Robot to every location 
	 * and cleans up all piles of beepers.  Think about ways you can break this
	 * large, complex task into smaller, easier to solve problems.
	 */
for (int i = 1; i <= 2; ){
	while (r.frontIsClear()==true){
		r.move();
      area++;
		while (r.nextToABeeper()==true){
			r.pickBeeper();
         beeper_number++;
			idv_pile++;
			if (idv_pile > largest_pile){
					idv_pile = largest_pile;
				}
         if (r.nextToABeeper()==false){
            pile_number++;
	//			if (idv_pile > largest_pile){
	//				idv_pile = largest_pile;
	//			}
			idv_pile = 0;
         }
		//}
		}
	}
   if(r.facingEast())
   {
      r.turnLeft();
      if(r.frontIsClear()){
      
      r.move();
      area++;
	   r.turnLeft();
      }else{
			System.out.println("The area is " + area);
			System.out.println("The number of beepers is " + beeper_number);
			System.out.println("There are " + pile_number + " piles");
			System.out.println("The largest pile has " + largest_pile + " beepers");
		}
   }
   else if(r.facingWest())
   {
      r.turnLeft();
      r.turnLeft();
      r.turnLeft();
      if(r.frontIsClear()){
         
      r.move();
      area++;
      r.turnLeft();
      r.turnLeft();
      r.turnLeft();
      }else{
			System.out.println("The area is " + area);
			System.out.println("The number of beepers is " + beeper_number);
			System.out.println("There are " + pile_number + " piles");
			System.out.println("The largest pile has " + largest_pile + " beepers");

		}
   }
	i = 0;
}
System.out.println("The area is " + area);
System.out.println("The number of beepers is " + beeper_number);

System.out.print("hi");
System.out.println("hello");



		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		//roomba.move();


  





  	/** This method displays the results of cleaning the room.  All of the info
	 * in the pdf that describes the problem need to be displayed.  You can present
	 * this info in the console (boring) or you can present using JOptionPane (cool!)
	 */

    //System.out.println("The biggest pile was ");
WorldScanner.close();
y_coordScanner.close();
x_coordScanner.close();
    







  }
}


   
