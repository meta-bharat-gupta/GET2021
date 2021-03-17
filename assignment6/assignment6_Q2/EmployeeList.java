package assignment6_Q2;

public class EmployeeList {
	
	/**
	 * Quick Sort for the Employees Type Linked List
	 * 
	 * @param empList
	 *            Linked List of the employee type
	 */
	public void quickSort(Node<Employee> head, Node<Employee> tail) {

		Node<Employee> start = head;
		Node<Employee> end = tail;

		// checking if list is empty
		if (start == null || start == end.getNext() || start == end) {
			return;
		}

		// calling partition method for partition of list
		Node<Employee> prevPivot = partition(start, end);
		// calling quick sort
		quickSort(start, prevPivot);

		if (prevPivot != null && prevPivot == start) {
			quickSort(prevPivot.getNext(), end);
		} else if (prevPivot != null && prevPivot.getNext() != null) {
			quickSort(prevPivot.getNext().getNext(), end);
		}
	}
	

	// Private helper method 
	// Takes start and end node and makes partition
	private Node<Employee> partition(Node<Employee> start, Node<Employee> end) {

		// if list is empty
		if (start == end || start == null || end == null) {
			return start;
		}

		Node<Employee> prevPivot = start;
		Node<Employee> current = start;

		// selecting the pivot node as end node
		Node<Employee> pivot = end;

		// Storing pivot node's data
		int pivotAge = end.getData().getAge();
		int pivotSalary = end.getData().getSalary();
		int pivotId = end.getData().getEmpId();
		String pivotName = end.getData().getName();

		// looping until the end
		while (start != end) {
			if (start.getData().compareTo(pivot.getData()) > 0) {
				// Keeping track of last modified node
				prevPivot = current;

				// Swapping Current and Start Node values
				int tempSalary = current.getData().getSalary();
				String tempName = current.getData().getName();
				int tempId = current.getData().getEmpId();
				int tempAge = current.getData().getAge();

				current.getData().setSalary(start.getData().getSalary());
				current.getData().setName(start.getData().getName());
				current.getData().setEmpId(start.getData().getEmpId());
				current.getData().setAge(start.getData().getAge());

				start.getData().setSalary(tempSalary);
				start.getData().setName(tempName);
				start.getData().setEmpId(tempId);
				start.getData().setAge(tempAge);

				current = current.getNext();
			}
			// setting start to next node
			start = start.getNext();
		}

		// Swapping end node and pivot node data
		int temp = current.getData().getSalary();
		int tempAge = current.getData().getAge();
		String tempName = current.getData().getName();
		int tempId = current.getData().getEmpId();

		current.getData().setSalary(pivotSalary);
		current.getData().setName(pivotName);
		current.getData().setEmpId(pivotId);
		current.getData().setAge(pivotAge);

		end.getData().setSalary(temp);
		end.getData().setAge(tempAge);
		end.getData().setEmpId(tempId);
		end.getData().setName(tempName);

		return prevPivot;
	}
	
	
	
}
