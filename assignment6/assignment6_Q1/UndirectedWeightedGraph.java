package assignment6_Q1;

public interface UndirectedWeightedGraph {

	public boolean isConnected();
	public void reachable(int v);
	public void mst();
	public void shortestPath(int source, int destination);
}
