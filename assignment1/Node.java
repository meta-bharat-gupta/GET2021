package assignment1;

// Generic Node Class for Linked List Implementation
public class Node<E> {
	private E data;
	private Node<E> next;
	public boolean visited = false;
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Node(E data){
		this.data = data;
		this.next = null;
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
