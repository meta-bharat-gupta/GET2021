package assignment3_Q3;

// BowlerQueue implementing the priority queue
public class BowlerQueue implements PQueue<Bowler>{
	// array of the bowler class for implementing a priority queue
	private Bowler[] heap;
	private int heapSize;
	private int capacity;
	
	/**
	 * Constructor for the bowler queue
	 * @param capacity
	 * 			integer capacity of the bowler queue
	 */
	public BowlerQueue(int capacity) {
		this.capacity = capacity+1;
		heap = new Bowler[this.capacity];
		this.heapSize = 0;
	}
	
	// Insert Method to insert a bowler in the queue
	@Override
	public void insert(Bowler newBowler) {
		if(heapSize==0){
			heap[heapSize] = newBowler;
			heapSize++;
		}else if(heapSize<capacity-1){
			int index = 0;
			// checking the place of the bowler in the queue
			// according to the balls he can bowl
			while(index<heapSize){
				if(!(heap[index].getBalls()>=newBowler.getBalls())){
					break;
				}
				index++;
			}
			// shifting other bowlers to the right
			for(int id = heapSize; id>=index; id--){
				heap[id+1] = heap[id];
			}
			heap[index] = newBowler;
			heapSize++;
		}else{
			System.out.println("Queue is Full. Can't Add more Bowlers.");
		}
		
	}

	// Returns the bowler with highest balls left
	@Override
	public Bowler getHighestPriority() {
		return heap[0];
	}

	// Deletes or removes the bowler with maximum balls remaining
	@Override
	public Bowler deleteHighestPriority() {
		if(heapSize==0){
			System.out.println("Priority Queue is Empty.");
			return null;
		}
		Bowler toDelete = heap[0];
		for(int index = 1; index<heapSize; index++){
			heap[index-1] = heap[index];
		}
		heapSize--;
		return toDelete;
	}
	
	// Displays the priority queue
	public void displayQueue(){
		if(heapSize==0){
			System.out.println("Priority Queue is Empty.");
			return;
		}
		for(int index = 0; index<heapSize; index++){
			System.out.println(heap[index].toString());
		}
	}
	
	
	// Displays the order of the bowlers for bowling 
	public void displayOrderOfBowlers(int noOfBalls){
		while(noOfBalls!=0 && heapSize!=0){
			Bowler curBowler = heap[0];
			System.out.println(curBowler.toString());
			this.deleteHighestPriority();
			if(curBowler.getBalls()>1){
				this.insert(new Bowler(curBowler.getName(), curBowler.getBalls()-1));				
			}
			noOfBalls--;
		}
	}
	
	
	// Getters and Setters of the class attributes
	public Bowler[] getHeap() {
		return heap;
	}

	public void setHeap(Bowler[] heap) {
		this.heap = heap;
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
