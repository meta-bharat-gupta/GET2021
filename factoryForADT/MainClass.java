package factoryForADT;

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
	
	// Main Class for menu driven approach
	public static void main(String[] args) {
		// Getting the new Screen by creating screen object.
		Screen screen = new Screen();
		while(true){
			System.out.println("\n\n------Graphics Library -------");
			System.out.println("1. For Add a Shape");
			System.out.println("2. For Delete a Shape");
			System.out.println("3. For Delete All shapes of Specific type");
			System.out.println("4. For sort the shapes");
			System.out.println("5. For checking A point is enclosed or not");
			System.out.println("6. Display All the shapes on the screen");
			System.out.println("7. Exit");
			System.out.println("Please Enter your choice: ");
			int userChoice = readInteger();
			switch(userChoice){
				case 1:
					screen.addShape();
					break;
				case 2:
					screen.deleteShape();
					break;
				case 3:
					screen.deleteAll();
					break;
				case 4:
					screen.sortShapes();
					break;
				case 5:
					screen.checkPoint();
					break;
				case 6:
					screen.displayShapes();
					break;
				case 7:
					return;
				default:
					System.out.println("Invalid Input...");
					break;
			}
		}
	}
}
