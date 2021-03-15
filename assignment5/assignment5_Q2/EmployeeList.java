package assignment5_Q2;

public class EmployeeList {
	
	/**
	 * Insertion Sort for the Employee Type Linked List
	 * @param empList
	 * 			Linked List of the employee type
	 */
	public void insertionSort(MyLinkedList<Employee> empList){
		// Initializing another node
		Node<Employee> sorted = null;
		// initializing current node with head
		Node<Employee> currentEmployee = empList.head;
		
		// iterating on all the nodes of the linked list
		while(currentEmployee.getNext()!=null){
			Node<Employee> nextNode = currentEmployee.getNext();
			sorted = insertionRecursively(currentEmployee, sorted);
			currentEmployee = nextNode;
		}
		sorted = insertionRecursively(currentEmployee, sorted);
		empList.head = sorted;	
	}
	
	
	// private helper method to compare Employee on the basis of their salary and age.
	private boolean compare(Node<Employee> firstNode, Node<Employee> secondNode){
		boolean bool = false;
		if(firstNode.getData().getSalary()<secondNode.getData().getSalary()){
			bool = true;
		}else if(firstNode.getData().getSalary() == secondNode.getData().getSalary()){
			if(firstNode.getData().getAge()>secondNode.getData().getAge()){
				bool = true;
			}
		}else{
			bool = false;
		}
		return bool;
	}
	
	// Private helper method for insertion sort
	private Node<Employee> insertionRecursively(Node<Employee> newNode, Node<Employee> sorted){
		
		if(sorted == null || compare(sorted, newNode)){
			newNode.setNext(sorted);
			sorted = newNode;
		}else{
			Node<Employee> current = sorted;
			while(current.getNext()!=null && current.getNext().getData().getSalary()>=newNode.getData().getSalary()){
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
		return sorted;
	}
}
