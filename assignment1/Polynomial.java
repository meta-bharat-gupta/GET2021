package assignment1;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Polynomial {
	public static MyLinkedList<MyLinkedList<Integer>> polynomial= new MyLinkedList<MyLinkedList<Integer>>();
	
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
	
	/**
	 * Function to get the degree of the polynomial.
	 * @return integer
	 * 			degree of the polynomial.
	 */
	public static int getDegree(){
		int length = polynomial.size();
		int degree = 0;
		for(int index = 0; index<length; index++){
			MyLinkedList<Integer> term;
			term = polynomial.get(index);
			int sum = 0;
			for(int val = 0; val<term.size()-1; val++){
				sum += term.get(val);
			}
			if(sum>=degree){
				degree = sum;
			}
		}
		return degree;
	}
	
	
	// main function to input the polynomial into the nested list.
	public static void main(String[] args) {
		out.println("Enter Number of Terms: ");
		int noOfTerms = readInteger();
		out.println("Enter Number of variables in polynomial: ");
		int noOfVar = readInteger();
		
		for(int index =0; index<noOfTerms; index++){
			MyLinkedList<Integer> term = new MyLinkedList<Integer>();
			polynomial.add(term);
			for(int var=0; var<noOfVar; var++){
				out.println("Enter "+ (var+1) + " variable's power: ");
				int varPower = readInteger();
				polynomial.get(index).add(varPower);
			}
			out.println("Enter co-efficient of the term: ");
			int coef = readInteger();
			polynomial.get(index).add(coef);
		}
		
		for(int index = 0; index<noOfTerms; index++){
			polynomial.get(index).print();
			out.println();
		}
		out.println("Degree of the Polynomial: ");
		out.println(getDegree());
	}
}
