package assignment6_Q2;

public class MainClass {
	
	// Main Class for calling insertion sort method
	public static void main(String[] args) {
		MyLinkedList<Employee> empList = new MyLinkedList<Employee>();
		empList.add(new Employee("Employee", 10, 400, 1));
		empList.add(new Employee("Employee1", 101, 5000, 2));
		empList.add(new Employee("Employee2", 40, 5000, 31));
		empList.add(new Employee("Employee3", 32, 5000, 4));
		empList.add(new Employee("Employee4", 41, 5000, 11));
		empList.add(new Employee("Employee5", 42, 22000, 32));
		empList.print();
		EmployeeList emp = new EmployeeList();
		Node<Employee> endNode = empList.getHead();
		while(endNode.getNext()!=null){
			endNode = endNode.getNext();
		}
		// Calling quick sort function 
		System.out.println("Quick Sort: ");
		emp.quickSort(empList.getHead(), endNode);
		empList.print();
	}
}
