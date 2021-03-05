package assignment1;

// Linked List Implementation
public class MyLinkedList<E> {
	public Node<E> head;
	
	/**
	 * function which checks whether Linked List is empty or not.
	 * @return boolean
	 * 			true if Linked List is empty otherwise false.
	 */
	public boolean isEmpty(){
		return head==null;
	}
	
	
	/**
	 * returns the size of the Linked List
	 * @return integer
	 * 			size of the linked list.
	 */
	public int size(){
		int size = 1;
		if(isEmpty()){
			size = 0;
		}else{
			Node<E> tempNode = head;
			while(tempNode.getNext()!=null){
				size++;
				tempNode = tempNode.getNext();
			}
		}
		return size;
	}
	
	
	/**
	 * Function to add an element into the Linked List
	 * @param data
	 * 			data which has to be stored in the node.
	 */
	public void add(E data){
		Node<E> toAdd = new Node<E>(data);
		if(isEmpty()){
			head = toAdd;
			return;
		}	
		Node<E> temp = head;
		while(temp.getNext()!=null){
				temp = temp.getNext();
		}
		temp.setNext(toAdd);
	}
	
	
	/**
	 * To print the elements of the Linked List.
	 */
	public void print(){
		Node<E> tempNode = head;
		while(tempNode!=null){
			System.out.print(" -> " + tempNode.getData() );
			tempNode = tempNode.getNext();
		}
	}
	
	
	/**
	 * It rotates the elements of a Linked List clockwise from a starting Index to end Index.
	 * @param startIndex
	 * 			start Index of the sublist which we have to rotate
	 * @param endIndex
	 * 			end Index of the sublist which we have to rotate
	 * @param rotCount
	 * 			no. of rotations we want to perform
	 */
	public void rotateClockwise(int startIndex, int endIndex, int rotCount){
		if(startIndex<=0 || endIndex>size()){
			System.out.println("Invalid Start or End Index.");
			return;
		}
		if(startIndex>endIndex){
			System.out.println("Start Index is greater than End Index");
			return;
		}
		if(startIndex==endIndex){
			return;
		}
		Node<E> tempNode = head;
		int count = 1;
		while(count<startIndex){
			tempNode = tempNode.getNext();
			count++;
		}
		Node<E> leftNode = tempNode;
		while(count<endIndex){
			tempNode = tempNode.getNext();
			count++;
		}
		Node<E> rightNode = tempNode;
		Node<E> firstNode = leftNode;
		Node<E> lastNode = rightNode;
		if(rightNode.getNext()==null){
			rightNode = null;
		}else{
			rightNode = lastNode.getNext();			
		}
		// rotation
		for(int rotation = 0; rotation<rotCount; rotation++){
			Node<E> temp = firstNode;
			while(temp.getNext()!=lastNode){
				temp = temp.getNext();
			}
			lastNode.setNext(firstNode);
			firstNode = lastNode;
			lastNode = temp;
		}

		//connect the rotated list to the original list
		lastNode.setNext(rightNode);
		if(startIndex == 1){
			head = firstNode;
		}else{
			count = 1;
			tempNode = head;
			while(count<startIndex-1){
				tempNode = tempNode.getNext();
				count++;
			}
			tempNode.setNext(firstNode);
		}
	}
	
	
	/**
	 * Function to check whether Linked List has a Loop or not
	 * @return boolean
	 * 			true if Linked List has a Loop otherwise false.
	 */
	public boolean hasLoop(){
		Node<E> tempNode = head;
//		head.getNext().getNext().setNext(head);
		while(tempNode.getNext()!=null){
			if(tempNode.isVisited()){
				return true;
			}
			tempNode.setVisited(true);
			tempNode = tempNode.getNext();
		}
		return false;
	}
	
	
	/**
	 * Function to get the element of the Linked List at a particular index(based 0)
	 * @param index
	 * 			integer index ranges from 0 to size of the linked list.
	 * @return 
	 * 			return the element of the linked list at the given index.
	 */
	public E get(int index){
		E result=null;
		if(index<0 || index>=size()){
			result = null;
		}
		Node<E> tempNode = head;
		int temp = 0;
		while(tempNode.getNext()!=null){
			if(temp==index){
				result = tempNode.getData();
				break;
			}
			tempNode = tempNode.getNext();
			temp++;
		}
		if(temp==index){
			result = tempNode.getData();
		}
		return result;
	}

}
