package inheritanceAndComposition;

import java.util.ArrayList;

// Zone Class to handle different zones in zoo
public class Zone {

	private String zoneCategory;
	private final int cageLimit = 5;
	private int currentCageNumbers;
	private ArrayList<Cage> cageList;
	private boolean hasPark = false;
	private boolean hasCanteen = false;
	
	
	/**
	 * Zone Constructor
	 * @param zoneCategory
	 * 			String category of the animals which lives in the zone
	 */
	public Zone(String zoneCategory){
		this.zoneCategory = zoneCategory;
		cageList = new ArrayList<Cage>();
	}
	
	// Add a new cage to the zone
	public boolean addCage(String type){
		boolean isAdded = false;
		if(this.currentCageNumbers<this.cageLimit){
			cageList.add(new Cage(type));
			this.currentCageNumbers++;
			isAdded = true;
		}
		return isAdded;
	}
	
	
	// Add a new animal to the Zone.
	public void addAnimal(Animal newAnimal){
		boolean isAdded = false;
		for(int index = 0; index<currentCageNumbers; index++){
			Cage cage = cageList.get(index);
			if(newAnimal.getAnimalType().equals(cage.getCageType()) && cage.hasRoom()){
				cage.addAnimal(newAnimal);
				isAdded = true;
				break;
			}
		}
		// if there is no room for new animal in existing cages
		// creating new cage
		if(!isAdded){
			if(currentCageNumbers<cageLimit){
				cageList.add(new Cage(newAnimal.getAnimalType()));
				currentCageNumbers++;
				isAdded = cageList.get(currentCageNumbers-1).addAnimal(newAnimal);
			}
		}
		// if there is no room for more cages in the zone
		if(!isAdded){
			System.out.println("Animal can't be added.");
		}
	}
	
	// Removing an animal from the zone with animalId
	public void removeAnimal(int animalId){
		for(int index = 0; index<currentCageNumbers; index++){
			Cage cage = cageList.get(index);
			if(cage.hasAnimalId(animalId)!=-1){
				cage.removeAnimal(animalId);
//				if(cage.getCurrentAnimalCount()==0){
//					this.currentCageNumbers--;
//					cageList.remove(index);
//				}
				break;
			}
		}
	}
	
	
	// Displaying All the animals present in the Zone with their cages.
	public void displayAnimals(){
		if(this.currentCageNumbers==0){
			System.out.println("\tNo Cages Found");
		}
		for(int index = 0; index<cageList.size(); index++){
			System.out.println("\tCage "+(index+1)+" --> "+ cageList.get(index).getCageType());
			cageList.get(index).displayAnimals();
		}
	}

	
	// Getters and Setters for Class Attributes
	
	public String getZoneCategory() {
		return zoneCategory;
	}
	public void setZoneCategory(String zoneCategory) {
		this.zoneCategory = zoneCategory;
	}
	public int getCageLimit() {
		return cageLimit;
	}
	public ArrayList<Cage> getCageList() {
		return cageList;
	}
	public void setCageList(ArrayList<Cage> cageList) {
		this.cageList = cageList;
	}
	public boolean isHasPark() {
		return hasPark;
	}
	public void setHasPark(boolean hasPark) {
		this.hasPark = hasPark;
	}
	public boolean isHasCanteen() {
		return hasCanteen;
	}
	public void setHasCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
	}
	
	
}
