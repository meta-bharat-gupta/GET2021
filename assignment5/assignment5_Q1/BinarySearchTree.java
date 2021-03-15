package assignment5_Q1;

// Binary Search Tree class for implement BST
public class BinarySearchTree {

	// root node
	Node root;
	
	// Constructor for BST
	public BinarySearchTree(){
		this.root = null;
	}
	
	// Adding new key-value pair using recursive function
	public void add(int key, String value){
		root = addRecursively(root, key, value);
	}
	
	
	// Private recursive function for adding new key-value pair
	private Node addRecursively(Node currentNode, int key, String value){
		// if current node is null
		if(currentNode == null){
			currentNode = new Node(key, value);
			return currentNode;
		}else{
			// if key is less than the node's value
			if(key<currentNode.getKey()){
				currentNode.setLeft(addRecursively(currentNode.getLeft(), key, value));
			}
			// if key is greater than the node's value
			else if(key>currentNode.getKey()){
				currentNode.setRight(addRecursively(currentNode.getRight(), key, value));
			}
		}
		return currentNode;
	}
	
	// Return the String value of particular key
	public String get(int key){
		Node currentNode = root;
		currentNode = getRecursively(currentNode, key);
		return currentNode.getValue();
	}
	
	// private recursive function to get the value of specific key
	private Node getRecursively(Node currentNode, int key){
		if(currentNode==null || currentNode.getKey()==key){
			return currentNode;
		}else if(key<currentNode.getKey()){
			currentNode = getRecursively(currentNode.getLeft(), key);
		}else if(key>currentNode.getKey()){
			currentNode = getRecursively(currentNode.getRight(), key);
		}
		return currentNode;
	}
	
	// delete the specific node by key
	public void delete(int key){
		root = deleteRecursively(root, key);
	}
	
	// private recursive method to remove specific node from BST
	private Node deleteRecursively(Node root, int key){
		// if root is null
		if(root == null){
			return root;
		}
		// 3 cases for deletion
		if(key<root.getKey()){
			root.setLeft(deleteRecursively(root.getLeft(), key));
		}else if(key>root.getKey()){
			root.setRight(deleteRecursively(root.getRight(), key));
		}else{
			if(root.getLeft()==null){
				return root.getRight();
			}else if(root.getRight() == null){
				return root.getLeft();	
			}else{
				root.setKey(maxValue(root.getLeft()));;
				root.setLeft(deleteRecursively(root.getLeft(), root.getKey()));
			}
		}
		return root;
	}
	
	// private method to get the maximum value from the left tree.
	private int maxValue(Node root){
		int maxValue = root.getKey();
		while(root.getLeft()!=null){
			maxValue = root.getRight().getKey();
			root = root.getRight();
		}
		return maxValue;
	}
	
	
	// Inorder traversal 
	// because inorder traversal gives us the sorted list of nodes in BST.
	public void inorderTraversal(){
		inorder(root);
	}
	
	// private recursive method for inorder traversal
	private void inorder(Node root){
		if(root!=null){
			inorder(root.getLeft());
			System.out.println(root.getKey() + " -> " +root.getValue());
			inorder(root.getRight());
		}
	}
	
	// private recursive method for rangesort
	private void rangeSortRecursive(Node root, int k1, int k2){
		if(root!=null){
			rangeSortRecursive(root.getLeft(), k1, k2);
			if(root.getKey()>=k1 && root.getKey()<=k2){
				System.out.println(root.getKey() + " -> " +root.getValue());				
			}
			rangeSortRecursive(root.getRight(), k1, k2);;
		}
	}
	
	// Displaying only those nodes which in the range of k1 and k2
	public void rangeSort(int k1, int k2){
		rangeSortRecursive(root, k1, k2);
	}
}