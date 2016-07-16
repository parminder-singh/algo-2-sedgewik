package in.parmindr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph implements IGraph {

	private ArrayList<List<Integer>> adjList;

	private int v;

	private int e;

	public Graph(int v) {
		this.v = v;
		adjList = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	public Graph(Scanner in) {
		this(in.nextInt());
		while (in.hasNextLine()) {
			addEdge(in.nextInt(), in.nextInt());
		}
	}

	@Override
	public void addEdge(int u, int v) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
		e++;
	}

	@Override
	public Iterable<Integer> adj(int u) {
		return adjList.get(u);
	}

	@Override
	public int V() {
		return v;
	}

	@Override
	public int E() {
		return e;
	}

}
