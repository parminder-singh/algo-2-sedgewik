package in.parmindr;

public abstract class IPathFinder {

	IPathFinder(IGraph graph, int source) {
	}

	public abstract boolean hasPath(int v);

	public abstract Iterable<Integer> path(int v);
}
