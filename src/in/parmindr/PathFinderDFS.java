package in.parmindr;

import java.util.Stack;

public class PathFinderDFS extends IPathFinder {

	boolean[] isMarked;
	int[] predecessor;

	public PathFinderDFS(IGraph graph, int source) {
		super(graph, source);
		isMarked = new boolean[graph.V()];
		predecessor = new int[graph.V()];
		isMarked[source] = true;
		predecessor[source] = source;
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

	@Override
	public boolean hasPath(int v) {
		return isMarked[v];
	}

	@Override
	public Iterable<Integer> path(int v) {
		Stack<Integer> path = new Stack<>();
		if (hasPath(v)) {
			path.push(v);
			while (predecessor[v] != v) {
				v = predecessor[v];
				path.push(v);
			}
		}
		return path;
	}

}
