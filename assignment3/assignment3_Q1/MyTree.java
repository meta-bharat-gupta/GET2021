package assignment3_Q1;

public class MyTree {
	// Root Node for the tree
	public TreeNode root = new TreeNode("root", null);
	public int totalNodes = 0;
	// Current Node for processing the nodes
	public TreeNode currentNode;

	
	/**
	 * Constructor for MyTree Class
	 * setting current Node to the root
	 */
	public MyTree(){
		root.setPath("root");
		this.currentNode = root;
		
	}
	
	/**
	 * Adding a new directory to the current directory
	 * @param data
	 * 			String name of the directory
	 * @return
	 * 			true if added otherwise false
	 */
	public boolean addDirectory(String data){
		boolean isAdded = false;
		TreeNode toAdd = new TreeNode(data, currentNode);
		currentNode.getChildNodes().add(toAdd);
		isAdded = true;
		totalNodes++;
		return isAdded;
	}
	
	
	/**
	 * Changing the current directory
	 * @param directory
	 * 			directory where user wants to switch
	 */
	public void changeDirectory(String directory){
		int totalChilds = currentNode.getChildNodes().size();
//		System.out.println(totalChilds);
		for(int index = 0; index<totalChilds; index++){
			TreeNode childNode = currentNode.getChildNodes().get(index);
			if(childNode.getData().equalsIgnoreCase(directory)){
				currentNode = childNode;
				break;
			}
		}
	}
	
	/**
	 * returns to the previous directory
	 */
	public void moveBack(){
		if(currentNode.getParent()==null){
			System.out.println("This is Root Node. Can't Move upwards.");
		}else{
			currentNode = currentNode.getParent();			
		}
	}
	
	/**
	 * Display the child nodes of the current node.
	 */
	public void display(){
		int totalChilds = currentNode.getChildNodes().size();
		for(int index = 0; index<totalChilds; index++){
			System.out.println(currentNode.getChildNodes().get(index).getData());
		}
	}
	
	
	/**
	 * Private function for find the directory recursively
	 * @param curNode
	 * 			TreeNode object
	 * @param directory
	 * 			String directory to find.
	 * @param isFound
	 * 			boolean whether we found any directory or not
	 * @return
	 * 			boolean isFound
	 */
	private boolean findRecursively(TreeNode curNode, String directory, boolean isFound){
		int totalChilds = curNode.getChildNodes().size();
		// iterating over all the child
		for(int index = 0; index<totalChilds; index++){
			TreeNode childNode = curNode.getChildNodes().get(index);
			if(childNode.getData().contains(directory)){
				 System.out.println(childNode.getPath());
				 isFound = true;
			}
			// recursive call for children
			isFound = findRecursively(curNode.getChildNodes().get(index), directory, isFound);
		}
		return isFound;
	}
	
	/**
	 * Function writes the paths where it finds the directory
	 * @param directory
	 * 			String directory to be find
	 */
	public void findDirectory(String directory){
		boolean isFound = false;
		TreeNode curNode = currentNode;
		isFound = findRecursively(curNode, directory, isFound);
		if(!isFound){
			System.out.println("Not Found any directory");
		}
	}
	
	/**
	 * Private helper method for printing the tree structure
	 * @param curNode
	 * 			current Node on which traversal is going on
	 * @param flag
	 * 			boolean array for the traversal path
	 * @param depth
	 * 			depth of the traversal
	 * @param isLast
	 * 			boolean if we are on the last children node
	 */
	private void printTreeRecursively(TreeNode curNode, boolean[] flag, int depth, boolean isLast ){
	    if (curNode == null) 
	        return;
	    
	    // u2514 L
	    // u251c |-
	    // u2500 -
	    // u2502 |
	    
	    for (int index = 1; index < depth; index++) {
	        // Condition when the depth is exploring
	        if (flag[index] == true) {
	            System.out.print("\u2502 " + " " + " " + " ");
	        }
	        // Otherwise print the blank spaces
	        else {
	            System.out.print(" " + " " + " " + " ");
	        }
	    }
	     
	    // if root node
	    if (depth == 0)
	        System.out.println(curNode.getData());
	     
	    // if it is the last node
	    else if (isLast) {
	        System.out.print("\u2514\u2500\u2500\u2500 " +  curNode.getData() + '\n');
	         
	        // no more children left
	        flag[depth] = false;
	    }
	    else {
	        System.out.print("\u251c\u2500\u2500\u2500 " +  curNode.getData() + '\n');
	    }
	
	    for (int id = 0; id<curNode.getChildNodes().size(); id++) {
	         TreeNode tempNode = curNode.getChildNodes().get(id);
	       
	        // for children nodes, recursive call
	        printTreeRecursively(tempNode, flag, depth + 1, 
	            id == (curNode.getChildNodes().size()) - 1);
	    }
	    flag[depth] = true;
	}
	
	/**
	 * This function displays all the nodes in tree fashion
	 */
	public void printTree(){
		boolean[] flag  = new boolean[this.totalNodes+1];
		for(int count = 0; count<flag.length; count++){
			flag[count] = true;
		}
		boolean isLast = false;
		printTreeRecursively(currentNode, flag, 0, isLast);
	}
}
