package assignment3_Q2;

// Task Class for the Priority Queue
public class Task {
	String job;
	int priority;
	
	/**
	 * Constructor for the class
	 * @param job
	 * 			String name of the job
	 * @param priority
	 * 			integer priority of the job
	 */
	public Task(String job, int priority){
		this.job = job;
		this.priority = priority;
	}
	
	// Getters and Setters of the class attributes
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString(){
		return "Job Name: "+this.job+", with priority: "+this.priority;
	}
	
}
