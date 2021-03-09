package assignment4_Q1;

public class Employee {
	private String empName;
	private String empAddress;
	private int empId;
	
	// Constructor for Employee Class
	public Employee(String empName, String empAddress, int id){
		this.empAddress = empAddress;
		this.empName = empName;
		this.empId = id;
	}
	
	// Getters and Setter for class attributes
	public String getName() {
		return empName;
	}
	public void setName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return empAddress;
	}
	public void setAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	// Print an Employee Object
	public void print(){
		System.out.println("Emp Id : "+	this.empId+", Emp Name : "+this.empName+
				", Emp Address : "+this.empAddress);
	}
}
