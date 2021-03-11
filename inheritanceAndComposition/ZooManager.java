package inheritanceAndComposition;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


// ZooManager Class for managing Zoo.
public class ZooManager {
	
	// List of the zones present in the zoo.
	private ArrayList<Zone> zoneList;
	
	// ZooManager Object Constructor
	// Adding three kinds of zone to the zoo.
	public ZooManager(){
			zoneList = new ArrayList<Zone>();
			zoneList.add(new Zone("Bird"));
		
			zoneList.add(new Zone("Mammal"));
		
			zoneList.add(new Zone("Reptile"));
	}
	
	
	// Adding Animal to the Zoo.
	public void addAnimal(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("1. Add a Lion");
		System.out.println("2. Add a Crocodile");
		System.out.println("3. Add a Peacock");
		System.out.println("Enter your choice: ");
		int userChoice = readInteger();
		System.out.println("Enter name: ");
		String name = userInput.nextLine();
		System.out.println("Enter age: ");
		int age = readInteger();
		System.out.println("Enter weight: ");
		int weight = readInteger();
		Zone relatedZone = null;
		switch(userChoice){
			// For Mammal types
			case 1:
				for(int index = 0; index<zoneList.size(); index++){
					if("Mammal".equals(zoneList.get(index).getZoneCategory())){
						relatedZone = zoneList.get(index);
						break;
					}
				}
				if(relatedZone!=null){
					relatedZone.addAnimal(new Lion(name, age, weight));					
				}else{
					System.out.println("Animal Addition Failed");
				}
				break;
			// For Reptile types
			case 2:
				for(int index = 0; index<zoneList.size(); index++){
					if("Reptile".equals(zoneList.get(index).getZoneCategory())){
						relatedZone = zoneList.get(index);
						break;
					}
				}
				if(relatedZone!=null){
					relatedZone.addAnimal(new Crocodile(name, age, weight));
				}else{
					System.out.println("Animal Addition Failed.");
				}
				break;
			// For Bird types
			case 3:
				for(int index = 0; index<zoneList.size(); index++){
					if("Bird".equals(zoneList.get(index).getZoneCategory())){
						relatedZone = zoneList.get(index);
						break;
					}
				}
				if(relatedZone!=null){
					relatedZone.addAnimal(new Peacock(name, age, weight));					
				}else{
					System.out.println("Animal Addition Failed");
				}
				break;
			default:
				System.out.println("Invalid Input.");
		}
//		userInput.close();
	}
	
	
	
	public void removeAnimal(){
		System.out.println("Enter animal Id to be removed: ");
		int animalId = readInteger();
		for(int index = 0; index<zoneList.size(); index++){
			zoneList.get(index).removeAnimal(animalId);
		}
	}
	
	public void displayAnimals(){
		for(int index = 0; index<zoneList.size(); index++){
			System.out.println("Zone --> "+ zoneList.get(index).getZoneCategory());
			zoneList.get(index).displayAnimals();
		}
	}
	
	
	public void addCageToZone(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter Zone Category (Mammal/Reptile/Crocodile): ");
		String zoneType = userInput.nextLine();
		System.out.println("Enter Animal Type for cage (Bird/Lion/Peacock): ");
		String cageType = userInput.nextLine();
		for(int zoneIndex = 0; zoneIndex<zoneList.size(); zoneIndex++){
			if(zoneType.equalsIgnoreCase(zoneList.get(zoneIndex).getZoneCategory())){
				zoneList.get(zoneIndex).addCage(cageType);
				break;
			}
		}
//		userInput.close();
	}
	
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
}
