package assignment5_Q2;

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
	
	public Node<E> getHead(){
		Node<E> root = head;
		return root;
	}
	
	/**
	 * returns the size of the Linked List
	 * @return integer
	 * 			size of the linked list.
	 */
	public int size(){
		// for root node
		int size = 1;
		
		// if There is no root node
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
			System.out.println(" -> " + tempNode.getData().toString() );
			tempNode = tempNode.getNext();
		}
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
		// if index is not valid
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
