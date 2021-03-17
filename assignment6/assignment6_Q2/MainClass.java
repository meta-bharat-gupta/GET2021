package assignment6_Q2;

public class MainClass {
	
	// Main Class for calling insertion sort method
	public static void main(String[] args) {
		MyLinkedList<Employee> empList = new MyLinkedList<Employee>();
		empList.add(new Employee("Employee", 10, 4, 1));
		empList.add(new Employee("Employee1", 101, 5, 2));
		empList.add(new Employee("Employee2", 10, 5, 31));
		empList.add(new Employee("Employee3", 102, 5, 4));
		empList.add(new Employee("Employee4", 1011, 5, 11));
		empList.add(new Employee("Employee5", 42, 22000, 32));
//		empList.print();
		EmployeeList emp = new EmployeeList();
		Node<Employee> endNode = empList.getHead();
		while(endNode.getNext()!=null){
			endNode = endNode.getNext();
		}
		emp.quickSort(empList.getHead(), endNode);
		empList.print();
	}
}
