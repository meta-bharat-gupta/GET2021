package specification_Q3;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		double height, width;
		while(true){
			System.out.println("--- Calculate Area ----");
			System.out.println("1. to calculate area of triangle");
			System.out.println("2. to calculate area of rectangle");
			System.out.println("3. to calculate area of square");
			System.out.println("4. to calculate area of circle");
			System.out.println("Please enter your choice: ");
			int userChoice = userInput.nextInt();
			switch(userChoice){
				case 1:
					System.out.println("Enter width of the triangle: ");
					width = userInput.nextDouble();
					System.out.println("Enter height of the triangle: ");
					height = userInput.nextDouble();
					System.out.println(Area.triangleArea(width, height));
					break;
				case 2:
					System.out.println("Enter width of the triangle: ");
					width = userInput.nextDouble();
					System.out.println("Enter height of the triangle: ");
					height = userInput.nextDouble();
					System.out.println(Area.rectangleArea(width, height));
					break;
				case 3:
					System.out.println("Enter side of the square: ");
					width = userInput.nextDouble();
					System.out.println(Area.squareArea(width));
					break;
				case 4:
					System.out.println("Enter radius of the circle: ");
					width = userInput.nextDouble();
					System.out.println(Area.circleArea(width));
					break;
				case 5:
					userInput.close();
					return;
				default:
					System.out.println("Invalid Choice, please try again.");
					break;
			}
		}
	}
}
