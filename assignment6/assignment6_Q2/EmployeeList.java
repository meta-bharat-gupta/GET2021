package assignment6_Q2;

public class EmployeeList {
	
	/**
	 * Quick Sort for the Employee Type Linked List
	 * @param empList
	 * 			Linked List of the employee type
	 */
	public void quickSort(Node<Employee> head, Node<Employee> tail){
		
		Node<Employee> start = head;
		Node<Employee> end=tail;
		
		if(start == null || start == end.getNext() || start == end){
			return;
		}
		
		Node<Employee> prevPivot = partition(start, end);
		quickSort(start, prevPivot);
		
		if(prevPivot!=null && prevPivot==start){
			quickSort(prevPivot.getNext(), end);
		}else if(prevPivot!=null && prevPivot.getNext()!=null){
			quickSort(prevPivot.getNext().getNext(), end);
		}
	}
	
	// Private helper method for making quick sort
	private Node<Employee> partition(Node<Employee> start, Node<Employee> end){
		
		if(start == end || start == null || end==null ){
			return start;
		}
		
		Node<Employee> prevPivot = start;
		Node<Employee> current = start;
		int pivot = current.getData().getSalary();
		
		while(start != end){
			if(start.getData().getSalary()>pivot){
				prevPivot = current;
                int temp = current.getData().getSalary();
                current.getData().setSalary(start.getData().getSalary());
                start.getData().setSalary(temp);
                current = current.getNext();
			}
			start = start.getNext();
		}
		
		int temp = current.getData().getSalary();
        current.getData().setSalary(pivot);
        end.getData().setSalary(temp);
        
        return prevPivot;
	}
	
	
	
}
