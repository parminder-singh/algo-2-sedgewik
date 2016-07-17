package in.parmindr;

import java.util.LinkedList;
import java.util.Queue;

public class PathFinderBFS extends PathFinder {

	protected PathFinderBFS(IGraph graph, int source) {
		super(graph, source);
	}

	@Override
	public void preCompute(IGraph graph, int source) {
		BFS(graph, source);
	}

	private void BFS(IGraph graph, int source) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int curr = queue.remove();
			for (int adj : graph.adj(curr)) {
				if (!isMarked[adj]) {
					isMarked[adj] = true;
					predecessor[adj] = curr;
					queue.add(adj);
				}
			}
		}
	}
}
