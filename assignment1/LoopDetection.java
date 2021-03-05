package assignment1;

import static java.lang.System.out;

public class LoopDetection {
	public static void main(String[] args) {
		MyLinkedList<Integer> myLL = new MyLinkedList<Integer>();
		myLL.add(1);
		myLL.add(2);
		myLL.add(3);
		myLL.add(4);
		myLL.add(5);
		
		myLL.print();
		
		out.println("\nlinked list has a Loop: " + myLL.hasLoop());
		
	}
}
