package assignment6_Q1;

public class MainClass {

	// Main Class for creating graph object and calling methods
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0,1,5); 
        graph.addEdge(0,2,20); 
        graph.addEdge(1,2,6);
        graph.addEdge(1,3,10); 
        graph.addEdge(2,4,5);
        graph.addEdge(3, 4, 0);
        graph.printGraph();
        graph.reachable(0);
        System.out.println("Graph is Connected: "+graph.isConnected());
        graph.mst();
        graph.shortestPath(0,2);
        
        graph = new Graph(6); 
        graph.addEdge(0,1,1); 
        graph.addEdge(0,4,7);
        graph.addEdge(0,2,2);
        graph.addEdge(1,2,3); 
        graph.addEdge(2,5,2); 
        graph.addEdge(2,3,4); 
        graph.addEdge(2,4,2);
        graph.addEdge(3,5,5);
        graph.printGraph();
        System.out.println(graph.isConnected());
        graph.mst();
        graph.shortestPath(1, 4);
	}
}
