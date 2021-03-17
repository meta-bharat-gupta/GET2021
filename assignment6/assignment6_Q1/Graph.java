package assignment6_Q1;

import java.util.ArrayList;


public class Graph implements UndirectedWeightedGraph{

	// Total number of vertices
	private int vertexCount;
	// Adjacency List Array
	private ArrayList<Edge> adjacencyList[];
	
	
	// Constructor for Graph Object
	public Graph(int numberOfVertex){
		this.vertexCount = numberOfVertex;
		this.adjacencyList = new ArrayList[numberOfVertex];
		for(int index=0; index<numberOfVertex; index++){
			this.adjacencyList[index] = new ArrayList<Edge>();
		}
	}
	
	// Print all the nodes and their neighbor nodes
	public void printGraph(){
		System.out.println("vertexCount: "+this.vertexCount);
		for(int i=0; i<this.vertexCount; i++){
			System.out.println("Neighbours of Vertex "+i+" ->");
			for(int j=0; j<adjacencyList[i].size(); j++){
				System.out.print(adjacencyList[i].get(j).getTo()+ " ");	
			}
			System.out.println();
		}
	}
	
	// Return number of vertices in the graph
	public int getVertices(){
		return this.vertexCount;
	}
	
	
	// Add Edge to the Graph
	public boolean addEdge(int source, int destination, int weight){
		// Adding edge from source to destination
		adjacencyList[source].add(new Edge(source, destination, weight));
		// Adding edge from destination to source due to undirected graph
		adjacencyList[destination].add(new Edge(destination, source, weight));
		return true;
	}

	// Checks whether Graph is connected or not
	// And returns boolean value
	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		boolean connected = true;
		int vertexCount = this.vertexCount;
		ArrayList<Edge> adjList[] = this.adjacencyList;
		boolean[] visited = new boolean[vertexCount];
		
		// Traversing the graph with Depth First Search
		DFS(0, adjList, visited);
		
		// Checking if any node is not visited
		for(int index=0; index<vertexCount; index++){
			if(!visited[index]){
				connected = false;
				break;
			}
		}		
		return connected;
	}
	
	// Depth First Search for the Graph
	private void DFS(int source, ArrayList<Edge> adjList[], boolean[] visited){
		visited[source] = true;
		
		// Calling DFS for all the neighbour nodes of the current node
		for(int index =0; index<adjList[source].size(); index++){
			if(visited[adjList[source].get(index).getTo()]==false){
				DFS(adjList[source].get(index).getTo(), adjList, visited);
			}
		}
	}

	// Prints all the reachable nodes from a particular node
	@Override
	public void reachable(int v) {
		// TODO Auto-generated method stub
		boolean[] vertices = new boolean[this.vertexCount];
		
		// Applying DFS for checking which nodes are reachable
		DFS(v, this.adjacencyList, vertices);
		System.out.println("Reachable Nodes: ");
		for(int index=0; index<vertices.length; index++){
			if(vertices[index])
				System.out.print(index + " ");
		}
		System.out.println();
	}

	// Prints the Edges present in the Minimum Spanning Tree of the Graph
	@Override
	public void mst() {
		// TODO Auto-generated method stub
		if(isConnected()){
			ArrayList<Edge> adjList[] = this.adjacencyList;
			createMST(this.vertexCount, adjList);			
		}else{
			System.out.println("Graph is not connected.");
		}
	}
	
	// Private helper method for creating MST for graph
	private void createMST(int noOfVertex, ArrayList<Edge> adjList[]){
		int[] parent = new int[noOfVertex];
		int[] key = new int[noOfVertex];
		
		boolean[] mstSet = new boolean[noOfVertex];
		
		for(int index=0; index<noOfVertex; index++){
			key[index] = Integer.MAX_VALUE;
			mstSet[index]=false;
		}
		// As we are starting from first node
		key[0] = 0;
		// parent node of first node
		parent[0] = -1;
		for(int vertex=0; vertex<noOfVertex; vertex++){
			int minKey = findMinKey(key, mstSet);
			mstSet[minKey] = true;
			
			ArrayList<Edge> neighbours = adjList[minKey];
			for(int index=0; index<neighbours.size(); index++){
				int currentNeighbour = neighbours.get(index).getTo();
				int currentNeighbourWeight = neighbours.get(index).getWeight();
				if(mstSet[currentNeighbour]==false){
					if(currentNeighbourWeight<key[currentNeighbour]){
						parent[currentNeighbour] = minKey;
						key[currentNeighbour] = currentNeighbourWeight;
					}
				}
			}
		}
		printMST(parent);
	}

	// private helper method for printing MST edges
	private void printMST(int[] parent){
		System.out.println("Edge Included in MST"); 
        for (int i = 1; i < this.vertexCount; i++){ 
            System.out.println(parent[i] + " - " + i);
        }
	}
	
	// private helper method to find minimum distance node in MST
	private int findMinKey(int[] key, boolean[] mstSet){
		int minKeyIndex = -1;
		for(int index=0; index<key.length; index++){
			if(mstSet[index]==false && (minKeyIndex ==-1 || key[index]<key[minKeyIndex])){
				minKeyIndex = index;
			}
		}
		return minKeyIndex;
	}
	
		
	// Prints the Shortest path from source node to the destination node
	// using Dijkstra algorithm
	@Override
	public void shortestPath(int source, int destination) {
		boolean visited[] = new boolean[this.vertexCount];
		int distance[] = new int[this.vertexCount];

		for (int vertex = 0; vertex < this.vertexCount; vertex++) {
			distance[vertex] = Integer.MAX_VALUE;
		}
		// distance from self is zero
		distance[source] = 0;

		// starting from source node and finding next minimum distance node
		for (int index = source; index < adjacencyList.length; index++) {
			int minimumVertex = findMinKey(distance, visited);
			visited[minimumVertex] = true;
			// updating neighbour nodes distances
			for (int counter = 0; counter < adjacencyList[minimumVertex].size(); counter++) {
				int currentNeighborVertex = adjacencyList[minimumVertex].get(counter).getTo();
				int currentNeighborVertexWeight = adjacencyList[minimumVertex].get(counter).getWeight();
				
				if (visited[currentNeighborVertex] == false) {
					int newDistance = distance[minimumVertex]
							+ currentNeighborVertexWeight;
					if (newDistance < distance[currentNeighborVertex])
						distance[currentNeighborVertex] = newDistance;
				}
				
			}
		}
		
		findAndPrintPath(distance, source, destination);
	}
	

	// private helper method for finding and printing path from minimum distance
	// array and source and destination nodes
	private void findAndPrintPath(int[] distance, int source, int destination){
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(destination);
		// Starting from destination
		int currentNode = destination;
		// Loop until we find source node
		while(currentNode!=source){
			ArrayList<Edge> edges = this.adjacencyList[currentNode];
			// iterating over all the neighbour nodes of the current node
			for(int index = 0; index<edges.size(); index++){
				if((distance[currentNode]-edges.get(index).getWeight())==distance[edges.get(index).getTo()]){
					path.add(edges.get(index).getTo());
					break;
				}
			}
			// setting the current node to the next node
			currentNode = path.get(path.size()-1);
		}
		System.out.println("Shortest Path: ");
		for(int id=path.size()-1; id>=0; id--){
			System.out.print(" -> "+ path.get(id));
		}
		System.out.println();
	}
	
}

