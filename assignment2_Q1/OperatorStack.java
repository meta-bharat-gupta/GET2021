package assignment2_Q1;

public class OperatorStack {
	private final int SIZE = 10;
	private String[] stackArray = new String[SIZE];
	private int top = -1;
	
	public boolean isEmpty(){
		return top == -1;
	}
	public String pop(){
		return stackArray[top--];
	}
	
	public void push(String data){
		top++;
		stackArray[top] = data;
	}
	
	public String peek(){
		String topValue = stackArray[top];
		return topValue;
	}
}
