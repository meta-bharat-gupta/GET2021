package assignment3_Q1;

// Generic Node Class for Linked List Implementation
public class Node<E> {
	private E data;
	private Node<E> next;
	public boolean visited = false;
	
	/**
	 * Constructor for Node
	 * @param data
	 * 			data to be put in the node.
	 */
	public Node(E data){
		this.data = data;
		this.next = null;
	}	

	// Getters and Setters for the class attributes
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}


}
