package in.parmindr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.hamcrest.collection.IsEmptyIterable;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

public class PathFinderDFSTest {

	@Test
	public void sanityTest() throws FileNotFoundException {
		Scanner in = new Scanner(new File(getClass().getResource("testGraph.txt").getFile()));
		IGraph graph = new Graph(in);
		PathFinderDFS pathFinder = new PathFinderDFS(graph, 4);
		assertEquals(false, pathFinder.hasPath(0));
		assertEquals(true, pathFinder.hasPath(1));
		assertEquals(true, pathFinder.hasPath(2));
		assertEquals(true, pathFinder.hasPath(3));
		assertEquals(true, pathFinder.hasPath(4));
		assertThat(pathFinder.path(3), IsIterableContainingInOrder.contains(3, 2, 1, 4));
		assertThat(pathFinder.path(0), IsEmptyIterable.emptyIterable());
	}
}
