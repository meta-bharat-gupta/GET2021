package assignment2_Q1;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter infix expression for evaluation: ");
		String expression = userInput.nextLine();
		int result = InfixEvaluation.infixEvaluation(expression);
		System.out.println("Result : "+ result);
		userInput.close();
	}
}
