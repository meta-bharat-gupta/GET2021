package assignment2_Q1;

public class OperandStack implements Stack<Integer>{
	private final int SIZE = 10;
	private int[] stackArray = new int[SIZE];
	private int top = -1;
	public boolean isEmpty(){
		return top==-1;
	}
	@Override
	public void push(Integer data) {
		if(top==SIZE-1){
			System.out.println("Stack is Full");
		}else{
			top++;
			stackArray[top] = data;
		}
	}
	@Override
	public Integer pop() {
		return stackArray[top--];
	}
	@Override
	public Integer peek() {
		return stackArray[top];
	}
	
	
}
