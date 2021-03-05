package assignment1;

public class MainClass {
	public static void main(String[] args) {
		MyLinkedList<Integer> myLL = new MyLinkedList<Integer>();
		myLL.add(1);
		myLL.add(2);
		myLL.add(3);
		myLL.add(4);
		myLL.add(5);
		myLL.add(6);
		myLL.add(7);
		myLL.print();
	
		System.out.println();
		System.out.println(myLL.size());
		myLL.rotateClockwise(1,2 , 7);
		myLL.print();
		
		for(int i=0; i<7; i++){
			System.out.println(myLL.get(i));
		}
		
	}
}
