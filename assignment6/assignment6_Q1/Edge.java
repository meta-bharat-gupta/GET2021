package assignment6_Q1;


public class Edge {

	// source node
	private int from;
	// destination node
	private int to;
	// weight of the edge
	private int weight;
	
	// Constructor for edge object
	public Edge(int from, int to, int weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public int getTo(){
		return this.to;
	}
	
	public int getFrom(){
		return this.from;
	}
	
	public int getWeight(){
		return this.weight;
	}
}
