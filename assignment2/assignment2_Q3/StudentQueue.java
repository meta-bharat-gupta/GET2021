package assignment2_Q3;

public class StudentQueue implements Queue<Student> {
	private int size;
	private Student[] queue;
	private int front = -1, rear = -1;
	
	public StudentQueue(int size) {
		this.size = size;
		queue = new Student[this.size];
	}
	@Override
	public boolean addStudent(Student student) {
		boolean isAdded = false;
		if (isFull()) {
			isAdded = false;
		} else if (isEmpty()) {
			front++;
			rear++;
			queue[rear] = student;
			isAdded = true;
		} else {
			rear = (rear + 1) % size;
			queue[rear] = student;
			isAdded = true;
		}
		return isAdded;
		
	}

	@Override
	public Student deleteStudent() {
		Student student;
		if (isEmpty()) {
			student = null;
		}
		// if only one element in queue
		else if (front == rear) {
			student = queue[front];
			front = -1;
			rear = -1;
		} else {
			student = queue[front];
			front = (front + 1) % size;
		}
		return student;
	}

	@Override
	public boolean isEmpty() {
		
		if(front == -1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		
		if(front == (rear + 1)%size){
			return true;
		}
		return false;
	}
	
}
