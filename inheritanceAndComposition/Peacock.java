package inheritanceAndComposition;

// Peacock class by extending Bird class
public class Peacock extends Bird{

	// Sound of the peacock
	private final String sound = "Pehooo";
	
	/**
	 * Constructor for Peacock Object
	 * @param name
	 * 			string name of the peacock
	 * @param age
	 * 			integer age of the peacock
	 * @param weight
	 * 			integer weight of the peacock
	 */
	public Peacock(String name, int age, int weight) {
		super(name, "Bird", age, weight);
		// TODO Auto-generated constructor stub
	}

	// returns the sound of the peacock
	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return this.sound;
	}

	// display the details of the peacock
	public void displayAnimal(){
		System.out.println("\t\tPeacock ->  AnimalID: "+this.getId()+", Name: "+ this.getName()
				+", Age: " + this.getAge() +", Weight: " + this.getWeight()+ ", Sound: "+ this.getSound());
	}
}
