package assignment3_Q1;


// Tree Node Class for the Tree
public class TreeNode {
	public String data;
	// Linked List of the TreeNodes
	public MyLinkedList<TreeNode> childNodes = new MyLinkedList<TreeNode>();
	public TreeNode parent;
	public String path;
	
	/**
	 * Constructor for TreeNode
	 * @param data
	 * 			String data to be put in the node
	 * @param parentNode
	 * 			TreeNode parent node of the current Node
	 */
	public TreeNode(String data, TreeNode parentNode){
		this.data = data;
		this.parent = parentNode;
		if(this.parent==null){
			this.path = "/";
		}else{
			this.path = parentNode.getPath() + "/" + this.data;			
		}
	}
	
	// Getters and Setters for the class attributes
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public MyLinkedList<TreeNode> getChildNodes() {
		return childNodes;
	}
	public void setChildNodeList(MyLinkedList<TreeNode> childNodeList) {
		this.childNodes = childNodeList;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	
}
