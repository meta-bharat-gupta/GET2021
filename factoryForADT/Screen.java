package factoryForADT;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import factoryForADT.Shape.ShapeType;

public class Screen {
	private List<Shape> shapeList = new ArrayList<Shape>();

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
	 * Check whether there is any shape on the screen or not.
	 * @return boolean
	 * 			true if screen is empty.
	 */
	public boolean isShapeListEmpty(){
		return shapeList.size()==0;
	}
	
	/**
	 * Add Shape to the screen after taking inputs from user.
	 */
	public void addShape(){
		System.out.println("1. For add a Circle");
		System.out.println("2. For add a Square");
		System.out.println("3. For add a Rectangle");
		System.out.println("4. For add a Triangle");
		
		int userChoice = readInteger();
		int xValue, yValue;
		Point origin;
		Shape object;
		List<Integer> params = new ArrayList<Integer>();
		if(userChoice>0 && userChoice<=4){
			System.out.println("Enter X-value of Origin Point: ");
			xValue = readInteger();
			System.out.println("Enter Y-value of Origin Point: ");
			yValue = readInteger();
			origin = new Point(xValue, yValue);
			switch(userChoice){
				case 1:
					System.out.println("Enter radius: ");
					params.add(readInteger());
					object = ShapeFactory.createShape(ShapeType.Circle, origin, params);
					shapeList.add(object);
					break;
				case 2:
					System.out.println("Enter Side: ");
					params.add(readInteger());
					object = ShapeFactory.createShape(ShapeType.Square, origin, params);
					shapeList.add(object);
					break;
				case 3:
					System.out.println("Enter Height: ");
					params.add(readInteger());
					System.out.println("Enter Width: ");
					params.add(readInteger());
					object = ShapeFactory.createShape(ShapeType.Rectangle, origin, params);
					shapeList.add(object);
					break;
				case 4:
					System.out.println("Enter Height: ");
					params.add(readInteger());
					System.out.println("Enter Width: ");
					params.add(readInteger());
					object = ShapeFactory.createShape(ShapeType.Triangle, origin, params);
					shapeList.add(object);
					break;
			}
		}else{
			System.out.println("Invalid Input..");
		}
		
	}
	
	/**
	 * Delete a Shape from the screen.
	 */
	public void deleteShape(){
		if(isShapeListEmpty()){
			System.out.println("List of Shapes is Empty.");
			return;
		}
		displayShapes();
		System.out.println("Enter Index of Shape which you want to delete: ");
		int userChoice = readInteger();
		if(userChoice<=0 || userChoice>shapeList.size()){
			System.out.println("Invalid Index");
		}else{
			shapeList.remove(userChoice-1);		
		}		
	}
	
	/**
	 * Private helper method for deleting all specific type shapes from screen.
	 * @param type
	 * 		type of the shape.
	 */
	private void deleteAllHelper(ShapeType type){
		int index = 0;
		String shapeType = type.toString();
		while(index<shapeList.size()){
			if(shapeType.compareTo(shapeList.get(index).getType())==0){
				shapeList.remove(index);
				index--;
			}
			index++;
		}
	}
	
	
	/**
	 * Delete All Specific Shapes from the Screen.
	 */
	public void deleteAll(){
		if(isShapeListEmpty()){
			System.out.println("List of Shapes is Empty.");
			return;
		}
		System.out.println("1. for delete all circles");
		System.out.println("2. for delete all squares");
		System.out.println("3. for delete all rectangles");
		System.out.println("4. for delete all triangles");
		int userChoice = readInteger();
		switch(userChoice){
			case 1:
				deleteAllHelper(ShapeType.Circle);
				break;
			case 2:
				deleteAllHelper(ShapeType.Square);
				break;
			case 3:
				deleteAllHelper(ShapeType.Rectangle);
				break;
			case 4:
				deleteAllHelper(ShapeType.Triangle);
				break;
			default:
				System.out.println("Invalid Input...");
				break;
		}
	}
	
	
	
	/**
	 * Checks which shapes enclose the given point and display a boolean value.
	 */
	public void checkPoint(){
		System.out.println("Enter the Point's Co-ordinates: ");
		System.out.println("Enter X-Coordinate: ");
		int xCord = readInteger();
		System.out.println("Enter Y-Coordinate: ");
		int yCord = readInteger();
		Point checkingPoint = new Point(xCord, yCord);
		
		for(int index = 0; index<shapeList.size(); index++){
			Shape shape = shapeList.get(index);
			Point origin = shape.getOrigin();
			System.out.println(shape.getType() + " with origin point : "+ origin.getX()+","+origin.getY() + " -> " + shape.isPointEnclose(checkingPoint));
		}
		
	}
	
	
	/**
	 * private helper method for sorting the shapes based on 
	 * the their area and displaying them in ascending order.
	 */
	private void sortOnArea(){
		List<Shape> listOfShapes = new ArrayList<Shape>(shapeList);
		Comparator<Shape> comparator = new Comparator<Shape>() {
			@Override
			public int compare(Shape First, Shape Second){
				if(First.getArea()>=Second.getArea()){
					return 1;
				}
				return -1;
			}
		};
		Collections.sort(listOfShapes, comparator);
		for(int index = 0; index<listOfShapes.size(); index++){
			Shape shape = listOfShapes.get(index);
			Point origin = shape.getOrigin();
			System.out.println(shape.getType() + " with origin: " + origin.getX()+","+origin.getY());
		}
	}
	
	
	/**
	 * private helper method for sorting the shapes based on 
	 * the their perimeter and displaying them in ascending order.
	 */
	private void sortOnPerimeter(){
		List<Shape> listOfShapes = new ArrayList<Shape>(shapeList);
		Comparator<Shape> comparator = new Comparator<Shape>() {
			@Override
			public int compare(Shape First, Shape Second){
				if(First.getPerimeter()>=Second.getPerimeter()){
					return 1;
				}
				return -1;
			}
		};
		Collections.sort(listOfShapes, comparator);
		for(int index = 0; index<listOfShapes.size(); index++){
			Shape shape = listOfShapes.get(index);
			Point origin = shape.getOrigin();
			System.out.println(shape.getType() + " with origin: " + origin.getX()+","+origin.getY());
		}
	}
	
	
	/**
	 * private helper method for sorting the shapes based on 
	 * the time they created and displaying them in ascending order.
	 */
	private void sortOnTime(){
		List<Shape> listOfShapes = new ArrayList<Shape>(shapeList);
		Comparator<Shape> comparator = new Comparator<Shape>() {
			@Override
			public int compare(Shape First, Shape Second){
				return First.getTimestamp().compareTo(Second.getTimestamp());
			}
		};
		Collections.sort(listOfShapes, comparator);
		for(int index = 0; index<listOfShapes.size(); index++){
			System.out.println(listOfShapes.get(index).getType() + " -> " + listOfShapes.get(index).getTimestamp());
		}
	}
	
	
	/**
	 * private helper method for sorting the shapes based on 
	 * the their origin distance from the origin of the screen
	 * and displaying them in ascending order.
	 */
	private void sortOnOriginDistance(){
		List<Shape> listOfShapes = new ArrayList<Shape>(shapeList);
		Comparator<Shape> comparator = new Comparator<Shape>() {
			@Override
			public int compare(Shape First, Shape Second){
				double firstDistance = Point.getDistance(First.getOrigin(), new Point(0,0));
				double secondDistance = Point.getDistance(Second.getOrigin(), new Point(0,0));
				if(firstDistance>=secondDistance){
					return 1;
				}
				return -1;
			}
		};
		Collections.sort(listOfShapes, comparator);
		for(int index = 0; index<listOfShapes.size(); index++){
			System.out.println(listOfShapes.get(index).getType() + " -> " + 
					listOfShapes.get(index).getOrigin().getX() + ","+listOfShapes.get(index).getOrigin().getY());
		}
	}
	
	
	/**
	 * This function is for sorting the shapes on the 
	 * screen based on different parameters.
	 */
	public void sortShapes(){
		System.out.println("1. Sort based on Area");
		System.out.println("2. Sort based on Perimeter");
		System.out.println("3. Sort based on Time Stamp");
		System.out.println("4. Sort based on Origin Distance");
		int sortChoice = readInteger();
		switch(sortChoice){
			case 1:
				sortOnArea();
				break;
			case 2:
				sortOnPerimeter();
				break;
			case 3:
				sortOnTime();
				break;
			case 4:
				sortOnOriginDistance();
				break;
			default:
				System.out.println("Invalid Input...");
		}
	}
	
	
	/**
	 * This function will display all the shapes present on the screen.
	 */
	public void displayShapes(){
		if(isShapeListEmpty()){
			System.out.println("List of Shapes is Empty.");
			return;
		}
		for(int index = 0; index<shapeList.size(); index++){
			Point origin = shapeList.get(index).getOrigin();
			String type = shapeList.get(index).getType();
			System.out.println((index+1)+ ". " +type+ " at "+ origin.getX()+","+origin.getY());
		}
	}

}
