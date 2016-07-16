package in.parmindr;

public interface IGraph {
	
	void addEdge(int u, int v);
	
	Iterable<Integer> adj(int u);
	
	int V();
	
	int E();

}
