package inheritanceAndComposition;

// Abstract Class for Animal
public abstract class Animal {
	private static int animalCount=0;
	private String name;
	private int id;
	private int weight;
	private int age;
	private String animalType;
	
	//Constructor for Animal
	public Animal(String name, String type, int age, int weight){
		this.name = name;
		this.animalType = type;
		this.age = age;
		this.weight = weight;
		this.id = animalCount++;
	}
	
	
	//Getters and Setters for class attributes
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	
	// abstract method for returning sound of particular animal.
	public abstract String getSound();
	
	// abstract method for display animal details
	public abstract void displayAnimal();
}
