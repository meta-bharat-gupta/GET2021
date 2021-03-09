package assignment4_Q2;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		while(true){
			System.out.println("Enter a String: ");
			String userString = userInput.nextLine();
			int characters = CountCharacters.countUniqueChar(userString);
			System.out.println("Unique Character's Count : "+ characters);			
		}
	}
}
