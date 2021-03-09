package assignment2_Q2;


public class CircularQueue implements Queue<Integer>{
	private final int SIZE = 10;
	private int[] queue = new int[SIZE];
	private int front = -1, rear = -1;

	/**
	 * Performs enQueue operation on the queue.
	 */
	@Override
	public boolean enQueue(Integer data) {
		boolean isAdded;
		if(isEmpty()){
			front++;
			rear++;
			isAdded = true;
		}else if(isFull()){
			isAdded = false;
		}else{
			rear = (rear+1)%SIZE;
			isAdded = true;
		}
		queue[rear] = data;
		return isAdded;
	}

	/**
	 * Perform deQueue operation on the queue.
	 */
	@Override
	public Integer deQueue() {
		// TODO Auto-generated method stub
		int value;
		if(isEmpty()){
			System.out.println("Queue is Empty.");
			value = -1;
		}else if(front == rear){
			value = queue[front];
			front = rear = -1;
		}else{
			value = queue[front];
			front = (front + 1)%SIZE;
		}
		return value;
	}

	/**
	 * Checks whether queue is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(front == -1){
			return true;
		}
		return false;
	}

	/**
	 * Checks whether queue is full or not.
	 */
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if(front == (rear + 1)%SIZE){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Displays all the elements of the queue from front to the rear
	 */
	public void print(){
		if(isEmpty()){
			System.out.println("Queue is Empty.");
		}else if(rear>=front){
			for(int index = front; index<=rear; index++){
				System.out.print(queue[index]+ " ");
			}
		}else{
			for(int index = front; index<SIZE; index++){
				System.out.print(queue[index]+" ");
			}
			for(int index = 0; index<=rear; index++){
				System.out.print(queue[index]+ " ");
			}
		}
	}
}
