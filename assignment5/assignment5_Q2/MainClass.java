package assignment5_Q2;

public class MainClass {
	
	public static void main(String[] args) {
		MyLinkedList<Employee> empList = new MyLinkedList<Employee>();
		empList.add(new Employee("Employee", 22, 42000, 1));
		empList.add(new Employee("Employee1", 22, 12000, 2));
		empList.add(new Employee("Employee2", 52, 212000, 31));
		empList.add(new Employee("Employee3", 13, 22000, 4));
		empList.add(new Employee("Employee4", 32, 223000, 11));
		empList.add(new Employee("Employee5", 42, 22000, 32));
//		empList.print();
		EmployeeList emp = new EmployeeList();
		emp.insertionSort(empList);
		empList.print();
	}
}
