package assignment4_Q1;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

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
		EmployeeCollection employeeList = new EmployeeCollection();
		while(true){
			System.out.println("1. To add employee");
			System.out.println("2. To sort employee list");
			System.out.println("3. To sort employee list by their names");
			System.out.println("4. To display the employee list");
			System.out.println("5. Exit");
			Scanner userInput = new Scanner(System.in);
			int userChoice = readInteger();
			switch(userChoice){
				case 1:
					System.out.println("Enter Employee Id: ");
					int id = readInteger();
					System.out.println("Enter Employee Name: ");
					String name = userInput.nextLine();
					System.out.println("Enter Employee Address: ");
					String address = userInput.nextLine();
					if(employeeList.addEmployee(new Employee(name, address, id))){
						System.out.println("Employee Added Successfully");
					}else{
						System.out.println("Employee Addition Failed.");
					}
					break;
				case 2:
					employeeList.sortByEmpId();
					break;
				case 3:
					employeeList.sortByEmpName();
					break;
				case 4:
					employeeList.displayEmployees();
					break;
				case 5:
					userInput.close();
					return;
				default:
					System.out.println("Invalid Input...");
			}
		}
	}
}
