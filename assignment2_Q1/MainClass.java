package assignment2_Q1;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
//		Scanner userInput = new Scanner(System.in);
//		System.out.println("Enter infix expression for evaluation: ");
//		String expression = userInput.nextLine();
		String expression = "4 + 5 + 5 / 5 + 3 + ( 4 + 3 )";
		int result = InfixEvaluation.infixEvaluation(expression);

		System.out.println("Result : "+ result);
//		userInput.close();
	}
}
