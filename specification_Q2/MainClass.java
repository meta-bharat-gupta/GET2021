package specification_Q2;

import java.util.Scanner;
import static java.lang.System.out;

public class MainClass {
	public static void main(String[] args) {
		int noOfStudents;
		Scanner scan = new Scanner(System.in);
		
		out.println("Enter the number of students: ");
		noOfStudents = scan.nextInt();
		
		int[] studentGrades = new int[noOfStudents];
		out.println("Please enter grades of "+ noOfStudents + " students: ");
		
		for(int student = 0; student<noOfStudents; student++){
			studentGrades[student] = scan.nextInt();
		}
		out.println("Average Grades :");
		float average = Marksheet.calculateAvg(studentGrades);
		out.println(average);
		
		out.println("Passed Student Percentage: ");
		out.println(Marksheet.passPercentage(studentGrades));
		
		scan.close();
	}
}
