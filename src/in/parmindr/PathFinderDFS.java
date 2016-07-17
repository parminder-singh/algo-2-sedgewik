package in.parmindr;

public class PathFinderDFS extends PathFinder {

	public PathFinderDFS(IGraph graph, int source) {
		super(graph, source);
	}

	@Override
	public void preCompute(IGraph graph, int source) {
		DFS(graph, source);
	}

	private void DFS(IGraph graph, int source) {
		for (int adjV : graph.adj(source)) {
			if (!isMarked[adjV]) {
				isMarked[adjV] = true;
				predecessor[adjV] = source;
				DFS(graph, adjV);
			}
		}
	}
}
