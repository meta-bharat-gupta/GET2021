package assignment3_Q3;

// Bowler Class for creating Bowler Object
public class Bowler {
	String name;
	int balls;
	
	/**
	 * Constructor for Bowler
	 * @param name
	 * 			String name of the bowler
	 * @param balls
	 * 			integer number of balls bowler can bowl
	 */
	public Bowler(String name, int balls){
		this.name = name;
		this.balls = balls;
	}
	
	// Getters and Setters of the class attributes
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	
	// Overriding the toString() method for printing the details of bowler
	@Override
	public String toString(){
		return "Bowler-> Name: "+this.name+", with balls: "+this.balls;
	}
	
}
