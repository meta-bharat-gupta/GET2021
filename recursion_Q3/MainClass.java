package recursion_Q3;

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
		out.println("Please Enter Board Size for NQueen Problem: ");
		int noOfQueens = readInteger();
		if(noOfQueens<=0){
			out.println("that is not a valid board size.");
		}else{
			NQueens.getResult(noOfQueens);			
		}
	}
}
