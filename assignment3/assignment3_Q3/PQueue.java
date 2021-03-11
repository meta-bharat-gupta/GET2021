package assignment3_Q3;

// Priority Queue Interface
public interface PQueue<E> {
	public void insert(E job);
	public E getHighestPriority();
	public E deleteHighestPriority();
}
