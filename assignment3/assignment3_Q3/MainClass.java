package assignment3_Q3;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MainClass {

	/**
	 * To read integer from input stream and check for wrong inputs.
	 * @return
	 * 		return input integer.
	 */
	public static int readInteger(){
		int userChoice;
		InputStreamReader userInput = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(userInput);
		while(true){
			try{
				userChoice = Integer.parseInt(bufferedReader.readLine());
				break;
			}catch(Exception e){
				out.println("Wrong Input Type. Please try again.");
			}
		}
		return userChoice;
	}
	
	
	// Main Function for Menu Driven Program.
	public static void main(String[] args) {
		BowlerQueue bowlerQueue;;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter Number of Balls Virat will play: ");
		int noOfBalls = readInteger();
		System.out.println("Enter number of bowlers: ");
		int noOfBowlers = readInteger();
		
		// Initializing the bowler queue
		bowlerQueue = new BowlerQueue(noOfBowlers);
		
		for(int count = 0; count<noOfBowlers; count++){
			System.out.println("Enter Bowler "+(count+1)+" Name: ");
			String bowlerName = userInput.nextLine();
			System.out.println("Enter No. of Balls: ");
			int balls = readInteger();
			bowlerQueue.insert(new Bowler(bowlerName, balls));
		}
		
		System.out.println("Available Bowlers: ");
		bowlerQueue.displayQueue();
		
		// displaying the bowlers order for bowling
		System.out.println("Order of Bowlers to choose: ");
		bowlerQueue.displayOrderOfBowlers(noOfBalls);
		userInput.close();
	}
}
