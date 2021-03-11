package assignment3_Q2;

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
	
	// Main function for menu driven program.
	public static void main(String[] args) {
		int maxSize = 5;
		PriorityQueue pQueue = new PriorityQueue(maxSize);
		Scanner userInput = new Scanner(System.in);
		while(true){
			System.out.println("1. To add job");
			System.out.println("2. To process highest priority job");
			System.out.println("3. To see the highest priority Job");
			System.out.println("4. To display priority Queue");
			System.out.println("5. Exit");
			int userChoice = readInteger();
			switch(userChoice){
				case 1:
					System.out.println("Enter Job Name: ");
					String jobName = userInput.nextLine();
					System.out.println("Enter priority: ");
					int priority = readInteger();
					Task newJob = new Task(jobName, priority);
					pQueue.insert(newJob);
					break;
				case 2:
					Task deletedJob = pQueue.deleteHighestPriority();
					if(deletedJob == null){
						break;
					}
					System.out.println("Processed Job->> " + deletedJob.toString());
					break;
				case 3:
					Task job = pQueue.getHighestPriority();
					System.out.println("Highest Priority Job->> " + job.toString());
					break;
				case 4:
					pQueue.displayQueue();
					break;
				case 5:
					userInput.close();
					return;
				default:
					System.out.println("Invalid Input.");
			}
		}
	}

}
