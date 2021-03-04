package assignment1;

public class MyLinkedList<E> {
	public Node<E> head;
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public int size(){
		int size = 1;
		if(isEmpty()){
			size = 0;
		}else{
			Node<E> tempNode = head;
			while(tempNode.getNext()!=null){
				size++;
				tempNode = tempNode.getNext();
			}
		}
		return size;
	}
	
	public void add(E data){
		Node<E> toAdd = new Node<E>(data);
		if(isEmpty()){
			head = toAdd;
			return;
		}	
		Node<E> temp = head;
		while(temp.getNext()!=null){
				temp = temp.getNext();
		}
		temp.setNext(toAdd);
	}
	
	public void print(){
		Node<E> tempNode = head;
		while(tempNode!=null){
			System.out.print(" -> " + tempNode.getData() );
			tempNode = tempNode.getNext();
		}
	}
	
	public void rotateClockwise(int startIndex, int endIndex, int rotCount){
		if(startIndex<=0 || endIndex>size()){
			System.out.println("Invalid Start or End Index.");
			return;
		}
		if(startIndex>endIndex){
			System.out.println("Start Index is greater than End Index");
			return;
		}
		if(startIndex==endIndex){
			return;
		}
		Node<E> tempNode = head;
		int count = 1;
		while(count<startIndex){
			tempNode = tempNode.getNext();
			count++;
		}
		Node<E> leftNode = tempNode;
		while(count<endIndex){
			tempNode = tempNode.getNext();
			count++;
		}
		Node<E> rightNode = tempNode;
		Node<E> firstNode = leftNode;
		Node<E> lastNode = rightNode;
		if(rightNode.getNext()==null){
			rightNode = null;
		}else{
			rightNode = lastNode.getNext();			
		}
		for(int rotation = 0; rotation<rotCount; rotation++){
			Node<E> temp = firstNode;
			while(temp.getNext()!=lastNode){
				temp = temp.getNext();
			}
			lastNode.setNext(firstNode);
			firstNode = lastNode;
			lastNode = temp;
		}

		lastNode.setNext(rightNode);
		if(startIndex == 1){
			head = firstNode;
		}else{
			count = 1;
			tempNode = head;
			while(count<startIndex-1){
				tempNode = tempNode.getNext();
				count++;
			}
			tempNode.setNext(firstNode);
		}
	}
	
	
	public boolean hasLoop(){
		Node<E> tempNode = head;
		head.getNext().getNext().setNext(head);
		while(tempNode.getNext()!=null){
			if(tempNode.isVisited()){
				return true;
			}
			tempNode.setVisited(true);
			tempNode = tempNode.getNext();
		}
		return false;
	}
	
	
//	public E get(int index){
//		E result= new E();
//		if(index < 0){
//			return result;
//		}
//		Node<E> tempNode = head;
//		int temp = 0;
//		while(tempNode.getNext()!=null){
//			if(temp==index){
//				result = tempNode.getData();
//				break;
//			}
//			tempNode = tempNode.getNext();
//			temp++;
//		}
//		if(temp==index){
//			result = tempNode.getData();
//		}
//		return result;
//	}

}
