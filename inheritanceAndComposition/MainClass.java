package inheritanceAndComposition;

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

	
	// Main Function for menu driven program.
	public static void main(String[] args) {
		ZooManager zoo = new ZooManager();
		
		while(true){
			System.out.println("\n----- Welcome to ZOO -------");
			System.out.println("1. for Add an animal");
			System.out.println("2. for Remove an animal");
			System.out.println("3. for Display all cages and animals");
			System.out.println("4. for Add cage to Zone");
			System.out.println("5. for Exit");
			int userChoice = readInteger();
			switch(userChoice){
				case 1:
					zoo.addAnimal();
					break;
				case 2:
					zoo.removeAnimal();
					break;
				case 3:
					zoo.displayAnimals();
					break;
				case 4:
					zoo.addCageToZone();
					break;
				case 5:
					return;
				default:
					System.out.println("Invalid Input...");
			}
		}
	}
}
