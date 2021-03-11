package assignment3_Q2;


//PriorityQueue Class by implementing PQueue interface
public class PriorityQueue implements PQueue<Task>{
	// Array of the Tasks
	private Task[] heap;
	private int heapSize;
	private int capacity;
	
	/**
	 * Constructor of the priority Queue
	 * @param capacity
	 * 			integer Taks holding capacity of the queue
	 */
	public PriorityQueue(int capacity) {
		this.capacity = capacity+1;
		heap = new Task[this.capacity];
		this.heapSize = 0;
	}
	
	// Function to insert new Task/Job into the priority Queue
	@Override
	public void insert(Task newJob) {
		if(heapSize==0){
			heap[heapSize] = newJob;
			heapSize++;
		}else if(heapSize<capacity-1){
			int index = 0;
			// Finding right place on the priority basis
			while(index<heapSize){
				if(!(heap[index].getPriority()>=newJob.getPriority())){
					break;
				}
				index++;
			}
			// shifting elements to the right side
			for(int id = heapSize; id>=index; id--){
				heap[id+1] = heap[id];
			}
			heap[index] = newJob;
			heapSize++;
		}else{
			System.out.println("Queue is Full. Can't Add more Jobs.");
		}
		
	}

	// Return the highest priority Task/Job from the priority queue
	@Override
	public Task getHighestPriority() {
		return heap[0];
	}

	// Process/Deletes the highest priority Task/Job from the queue
	@Override
	public Task deleteHighestPriority() {
		if(heapSize==0){
			System.out.println("Priority Queue is Empty.");
			return null;
		}
		Task toDelete = heap[0];
		// shifting all the elements to the left side
		for(int index = 1; index<heapSize; index++){
			heap[index-1] = heap[index];
		}
		heapSize--;
		return toDelete;
	}
	
	// Display the Priority Queue
	public void displayQueue(){
		if(heapSize==0){
			System.out.println("Priority Queue is Empty.");
			return;
		}
		for(int index = 0; index<heapSize; index++){
			System.out.println(heap[index].toString());
		}
	}
	
	
	// Getters and Setters for the class attributes
	public Task[] getHeap() {
		return heap;
	}

	public void setHeap(Task[] heap) {
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
