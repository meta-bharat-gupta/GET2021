package assignment3_Q2;

// Priority Queue Interface
public interface PQueue<E> {
	public void insert(E job);
	public E getHighestPriority();
	public E deleteHighestPriority();
}
