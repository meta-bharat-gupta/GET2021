package assignment2_Q1;

// Interface for Stack Implementation
public interface Stack<E> {
	public void push(E data);
	public E pop();
	public E peek();
	public boolean isEmpty();
}
