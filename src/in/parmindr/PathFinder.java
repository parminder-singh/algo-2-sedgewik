package in.parmindr;

import java.util.Stack;

public abstract class PathFinder {

	protected boolean[] isMarked;
	protected int[] predecessor;

	protected PathFinder(IGraph graph, int source) {
		isMarked = new boolean[graph.V()];
		predecessor = new int[graph.V()];
		isMarked[source] = true;
		predecessor[source] = source;
		preCompute(graph, source);
	}

	public boolean hasPath(int v) {
		return isMarked[v];
	}

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

	public abstract void preCompute(IGraph graph, int source);

}
