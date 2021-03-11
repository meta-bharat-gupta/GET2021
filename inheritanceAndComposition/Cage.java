package inheritanceAndComposition;

import java.util.ArrayList;

// Cage class 
public class Cage {
	private final int cageCapacity = 3;
	private String cageType;
	private int currentAnimalCount;
	private ArrayList<Animal> animalList;
	
	//Initialize Cage for specific type of animals
	public Cage(String animalTypeForCage){
		this.cageType = animalTypeForCage;
		this.currentAnimalCount = 0;
		this.animalList = new ArrayList<Animal>();
	}
	
	// Checks whether space available or not
	public boolean hasRoom(){
		if(currentAnimalCount<cageCapacity){
			return true;
		}
		return false;
	}
	
	//Add Animal to the Cage
	public boolean addAnimal(Animal newAnimal){
		boolean isAdded = false;
		if(currentAnimalCount<cageCapacity && cageType.equals(newAnimal.getAnimalType())){
			animalList.add(newAnimal);
			currentAnimalCount++;
			isAdded = true;
		}
		return isAdded;
	}
	
	//Remove Animal from the Cage
	public boolean removeAnimal(int animalId){
		boolean isRemoved = false;
		for(int count=0; count<currentAnimalCount; count++){
			if(animalId == animalList.get(count).getId()){
				animalList.remove(count);
				currentAnimalCount--;
				isRemoved = true;
				break;
			}
		}
		return isRemoved;
	}
	
	// return the animal Id if animal is present in the cage
	public int hasAnimalId(int animalId){
		int index = -1;
		for(int count = 0; count<currentAnimalCount; count++){
			if(animalList.get(count).getId() == animalId){
				index = count;
				break;
			}
		}
		return index;
	}
	
	// display the animals present in the cage
	public void displayAnimals(){
		if(currentAnimalCount==0){
			System.out.println("\t\tNo Animals Found");
		}
		for(int count =0; count<currentAnimalCount; count++){
			animalList.get(count).displayAnimal();
		}
	}
	
	
	// Getters and Setter for Class Attributes
	
	public ArrayList<Animal> getAnimalList() {
		return animalList;
	}
	public void setAnimalList(ArrayList<Animal> animalList) {
		this.animalList = animalList;
	}
	public int getCageCapacity() {
		return cageCapacity;
	}
	
	public String getCageType() {
		return cageType;
	}
	public void setCageType(String cageType) {
		this.cageType = cageType;
	}
	public int getCurrentAnimalCount() {
		return currentAnimalCount;
	}
	public void setCurrentAnimalCount(int currentAnimalCount) {
		this.currentAnimalCount = currentAnimalCount;
	}
	
	
}
