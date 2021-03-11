package inheritanceAndComposition;

public class Crocodile extends Reptile {

	// sound of the crocodile
	private final String sound = "Hisses";
	
	/**
	 * Constructor for crocodile object
	 * @param name
	 * 			String name of the crocodile
	 * @param age
	 * 			integer age of the crocodile
	 * @param weight
	 * 			integer weight of the crocodile
	 */
	public Crocodile(String name, int age, int weight) {
		super(name, "Reptile", age, weight);
		// TODO Auto-generated constructor stub
	}

	// returns the sound of the crocodile
	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return this.sound;
	}
	
	// display the crocodile details
	public void displayAnimal(){
		System.out.println("\t\tCrocodile ->  AnimalID: "+this.getId()+", Name: "+ this.getName()
				+", Age: " + this.getAge() +", Weight: " + this.getWeight()+ ", Sound: "+ this.getSound());
	}
}
