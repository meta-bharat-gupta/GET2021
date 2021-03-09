package assignment2_Q1;

public class OperatorStack {
	private final int SIZE = 10;
	private String[] stackArray = new String[SIZE];
	private int top = -1;
	
	/**
	 * Checks whether stack is empty or not
	 * @return
	 * 		true if empty otherwise false
	 */
	public boolean isEmpty(){
		return top == -1;
	}
	
	/**
	 * Pop the Data from the top of the stack.
	 * @return String
	 * 		Data at the top
	 */
	public String pop(){
		return stackArray[top--];
	}
	
	/**
	 * Push the data into the stack.
	 * @param data
	 * 		String data
	 */
	public void push(String data){
		top++;
		stackArray[top] = data;
	}
	
	/**
	 * Returns the top value of the stack.
	 */
	public String peek(){
		String topValue = stackArray[top];
		return topValue;
	}
}
