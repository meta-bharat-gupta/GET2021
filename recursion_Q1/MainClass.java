package recursion_Q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.out;

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
		int firstNum, secondNum;
		while(true){
			out.println("1. for L.C.M.");
			out.println("2. for H.C.F.");
			out.println("3. for Exit.");
			int userChoice = readInteger();
			switch(userChoice){
				case 1:
					out.println("Enter two numbers: ");
					firstNum = readInteger();
					secondNum = readInteger();
					out.println(Recursion.findLCM(firstNum, secondNum));
					break;
				case 2:
					out.println("Enter two numbers: ");
					firstNum = readInteger();
					secondNum = readInteger();
					out.println(Recursion.findHCF(firstNum, secondNum));
					break;
				case 3:
					return;
				default:
					out.println("Invalid Input. Please Try Again.");
					break;
			}
		}
	}

}
