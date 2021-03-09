package assignment2_Q2;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
	
	public static void main(String[] args) {
		Queue<Integer> queue = new CircularQueue();
		while(true){
			System.out.println("\n------ Queue Implementation ------");
			System.out.println("1. For enqueue operation");
			System.out.println("2. For dequeue operation");
			System.out.println("3. For print the queue");
			System.out.println("4. For Exit");
			int userChoice = readInteger();
			switch(userChoice){
				case 1:
					System.out.println("Enter the value : ");
					int value = readInteger();
					if(queue.enQueue(value)){
						System.out.println("Operation Success.");
					}else{
						System.out.println("Operation Failed.");
					}
					break;
				case 2:
					int dequeueValue = queue.deQueue();
					System.out.println("Value from dequeue operation : "+ dequeueValue);
					break;
				case 3:
					queue.print();
					break;
				case 4:
					return;
				default:
					System.out.println("Invalid Input...");
			}
		}
	}
}
