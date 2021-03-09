package assignment2_Q2;

// Generic Queue Interface
public interface Queue<E> {
	public boolean enQueue(E data);
	public E deQueue();
	public boolean isEmpty();
	public boolean isFull();
	public void print();
}
