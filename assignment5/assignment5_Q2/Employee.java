package assignment5_Q2;

public class Employee {

	private String empName;
	private int age;
	private int salary;
	private int empId;

	// Constructor for Employee Class
	public Employee(String empName, int age, int salary, int id){
		this.empName = empName;
		this.age = age;
		this.salary = salary;
		this.empId = id;
	}

	// Getters and Setter for class attributes
	public String getName() {
		return empName;
	}
	public void setName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	// Print an Employee Object
	public String toString(){
		return ("Emp Id : "+ this.empId+", Emp Name : "+this.empName+
				", Emp Age : "+this.age+", Salary: "+this.salary);
	}

}


