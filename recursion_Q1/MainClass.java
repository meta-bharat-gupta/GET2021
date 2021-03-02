package recursion_Q1;

import java.util.Scanner;
import static java.lang.System.out;

public class MainClass {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int firstNum, secondNum;
		while(true){
			out.println("1. for L.C.M.");
			out.println("2. for H.C.F.");
			out.println("3. for Exit.");
			int userChoice = userInput.nextInt();
			switch(userChoice){
				case 1:
					out.println("Enter two numbers: ");
					firstNum = userInput.nextInt();
					secondNum = userInput.nextInt();
					out.println(Recursion.findLCM(firstNum, secondNum));
					break;
				case 2:
					out.println("Enter two numbers: ");
					firstNum = userInput.nextInt();
					secondNum = userInput.nextInt();
					out.println(Recursion.findHCF(firstNum, secondNum));
					break;
				case 3:
					userInput.close();
					return;
				default:
					out.println("Invalid Input. Please Try Again.");
					break;
			}
		}
	}

}
