package assignment2_Q1;

public class OperandStack implements Stack<Integer>{
	private final int SIZE = 10;
	private int[] stackArray = new int[SIZE];
	private int top = -1;
	
	/**
	 * Return true if stack is empty otherwise false.
	 */
	public boolean isEmpty(){
		return top==-1;
	}
	
	/**
	 * Push the Data into the stack.
	 */
	@Override
	public void push(Integer data) {
		if(top==SIZE-1){
			System.out.println("Stack is Full");
		}else{
			top++;
			stackArray[top] = data;
		}
	}
	
	/**
	 * Pop the data from the stack and returns it.
	 */
	@Override
	public Integer pop() {
		return stackArray[top--];
	}
	
	/**
	 * Returns the top value of the stack
	 */
	@Override
	public Integer peek() {
		return stackArray[top];
	}
	
	
}
