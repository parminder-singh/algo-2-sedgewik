package in.parmindr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;

public class GraphTest {

	@Test
	public void sanityTest() throws FileNotFoundException {
		Scanner in = new Scanner(new File(getClass().getResource("testGraph.txt").getFile()));
		IGraph graph = new Graph(in);
		assertEquals(graph.V(), 4);
		assertEquals(graph.E(), 4);
		assertThat(graph.adj(0), IsCollectionContaining.hasItems(1,2,3));
		assertThat(graph.adj(1), IsCollectionContaining.hasItems(0));
		assertThat(graph.adj(2), IsCollectionContaining.hasItems(0,3));
		assertThat(graph.adj(3), IsCollectionContaining.hasItems(0,2));
	}
}
