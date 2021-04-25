import java.util.Scanner;
import java.util.Random;
/*
 *
 * 
 * This program simulates the game of Craps
 *
 *Author: Kody Fong ( kbfong@ucsc.edu)
 *
 *
 *
 */
public class Craps
{
    public static void main(String[]args)
    {
	Scanner one = new Scanner(System.in);
	System.out.println("Enter in your seed");
	int seed = one.nextInt();
	Random rand = new Random(seed); //This allows the game to be replicated
	int chips = 0;
	int bet = 0;
	System.out.println("How many chips do you want?");
	chips = one.nextInt(); //prompts the user to enter how many chips the player wants to play with
	while(chips>0) //keeps running as long as the player has chips to bet with 
	    {
		
		System.out.println("Enter your bet");
		bet = one.nextInt(); //Allows the user to enter in their bet
		while(bet > chips) //This stops the user from betting more than the chips available
		    {
			System.out.println("Not an okay bet");
			System.out.println("Enter your bet");
			bet = one.nextInt();
		    }
		System.out.println("Hit return to roll the dice");
		roll(); //calls the method roll to roll the dice
		int toss1 = rand.nextInt(6)+1; //creates a random value for a dice
		int toss2 = rand.nextInt(6)+1; //creates a random value for a dice
		System.out.println("Your rolls are " + toss1 + "," + toss2);
		int points = toss1 + toss2; //the sum of the dice
		if(points == 7 || points ==11) //if 7 or 11 you win
		    {
			chips += bet; //adds chips to total
			System.out.println("You win, you now have " + chips);
			
		    }
		else if( points == 2 || points ==3 || points ==12) // if 2 3 or 12 you lose
		    {
			chips = chips - bet; //subtracts chips from total
			System.out.println("You lose, you now have " +  chips);
		    }
		else //the start of the rolls if a 2 3 7 or 12 is not a result
		    {
		  
			System.out.println("The point is " + points);
			System.out.println("Hit return to roll the dice");
			roll();
			int toss3 = rand.nextInt(6)+1; //creates random values for the next dice rolls
			int toss4 = rand.nextInt(6)+1; // creates random values for the next dice rolls
			int point2 = toss3 + toss4;
			System.out.println("Your rolls are " + toss3 + "," + toss4);
			if(point2 ==7)
			    {
				chips = chips - bet; //subtracts chips from mtotal if you get a 7 on the second roll
				System.out.println("You lose, you now have " + chips);
				
			    }
	     
			while(point2 !=7 || point2 == points) //keeps rolling the dice until you win or lose
			    {
				int toss5 = rand.nextInt(6)+1;
				int toss6 = rand.nextInt(6)+1;
				point2 = toss5 + toss6;
				System.out.println("Hit return to roll the dice");
				roll();
				System.out.println("Your rolls are " + toss5 + "," + toss6);
				

			 if(points == point2)
			    {
				chips += bet; //adds chips to total if the two points are equal
				System.out.println("You win, you now have " + chips);
				break; //breaks the while loop so that the program can start from the beginning if this outcome is achieved
		   
			    }
			 else if(point2 ==7)
			     {
				 chips = chips - bet; //subtracts chips from total if 7 is the result
				 System.out.println("You lose, you now have " + chips);
				 break; //breaks the while loop so that the program can start from the beginning if this outcome is achieved
			     }
			     
				
			     
			    }
		    }
	    }
    }
    
     
	       
       public static  void roll()
    {
	Scanner in = new Scanner(System.in);
	boolean rollAgain = false;
	if(in.nextLine().equals(" ")) //this allows the user to press return to roll the dice when the method roll() is called
	   {
	       rollAgain = true;
	       
	   }
    }
 
    

}
