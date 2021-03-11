package inheritanceAndComposition;

// Lion class extending Mammal class
public class Lion extends Mammal {
	
	// Sound of the Lion
	private final String sound = "Roars";

	
	/**
	 * Constructor for Lion Object
	 * @param name
	 * 			String of lion's name
	 * @param age
	 * 			integer age of the lion
	 * @param weight
	 * 			integer weight of the lion
	 */
	public Lion(String name, int age, int weight) {
		super(name, "Lion", age, weight);
		// TODO Auto-generated constructor stub
	}
	
	// return the sound of the lion
	public String getSound(){
		return this.sound;
	}

	// display the details of the lion
	public void displayAnimal(){
		System.out.println("\t\tLion -> AnimalID: "+this.getId()+", Name: "+ this.getName()
				+", Age: " + this.getAge() +", Weight: " + this.getWeight()+ ", Sound: "+ this.getSound());
	}
}
