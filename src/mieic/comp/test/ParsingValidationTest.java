package mieic.comp.test;

import mieic.comp.graph.Edge;
import mieic.comp.graph.Graph;
import mieic.comp.graph.Vertex;
import mieic.comp.parser.Dot2DotParser;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertNotNull;

public class ParsingValidationTest {

	@Test
	public void test() {

		// to be modified
		File f = null;
		for (int i = 1; (f = new File("test_files/test" + i + ".dot")).exists(); i++) {
			assertNotNull(Dot2DotParser.parse(f.getPath()));
		}
	}

	@Test
	public void testShortPath() {

		File f = new File("test_files/test5.dot");

		if (f.exists()) {
			Graph g = Dot2DotParser.parse(f.getPath());

			assertNotNull(g);

			g.computePaths(g.getVertex("a"));
			ArrayList<Vertex> path = g.getShortestPathTo(g.getVertex("z"));
			ArrayList<Vertex> test = new ArrayList<>();
			test.add(g.getVertex("a"));
			test.add(g.getVertex("b"));
			test.add(g.getVertex("x"));
			test.add(g.getVertex("z"));
			Assert.assertEquals(test, path);
		}

		f = new File("test_files/test2.dot");

		if (f.exists()) {
			Graph g = Dot2DotParser.parse(f.getPath());

			assertNotNull(g);

			g.computePaths(g.getVertex("main"));
			ArrayList<Vertex> path = g.getShortestPathTo(g
					.getVertex("make_string"));
			ArrayList<Vertex> test = new ArrayList<>();
			test.add(g.getVertex("main"));
			test.add(g.getVertex("init"));
			test.add(g.getVertex("make_string"));
			Assert.assertEquals(test, path);

			g.computePaths(g.getVertex("parse"));
			path = g.getShortestPathTo(g.getVertex("compare"));
			test = new ArrayList<>();
			test.add(g.getVertex("parse"));
			test.add(g.getVertex("execute"));
			test.add(g.getVertex("compare"));
			Assert.assertEquals(test, path);

			path = g.getShortestPathTo(g.getVertex("cleanup"));
			test = new ArrayList<>();
			test.add(g.getVertex("cleanup"));
			Assert.assertEquals(test, path);

			path = g.getShortestPathTo(g.getVertex("parse"));
			test = new ArrayList<>();
			test.add(g.getVertex("parse"));
			Assert.assertEquals(test, path);
		}

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testPrim() {

		File f = new File("test_files/test6.dot");

		if (f.exists()) {
			Graph g = Dot2DotParser.parse(f.getPath());

			assertNotNull(g);

			HashSet<Edge> span = g.prim("a");
			HashSet<Edge> test = new HashSet<>();

			for (Edge e : g.getEdgesFromNode(g.getVertex("a"))) {
				if (((Vertex) e.getOrigin()).getName().equals("a")
						&& ((Vertex) e.getDestination()).getName().equals("b")) {

					test.add(e);
					break;
				}
			}

			for (Edge e : g.getEdgesFromNode(g.getVertex("b"))) {
				if (((Vertex) e.getOrigin()).getName().equals("b")
						&& ((Vertex) e.getDestination()).getName().equals("e")) {
					test.add(e);
					break;
				}
			}

			for (Edge e : g.getEdgesFromNode(g.getVertex("e"))) {
				if ((((Vertex) e.getOrigin()).getName().equals("d") && ((Vertex) e
						.getDestination()).getName().equals("e"))) {
					test.add(e);
				}

				if ((((Vertex) e.getOrigin()).getName().equals("e") && ((Vertex) e
						.getDestination()).getName().equals("f"))) {
					test.add(e);
				}
			}

			for (Edge e : g.getEdgesFromNode(g.getVertex("f"))) {
				if (((Vertex) e.getOrigin()).getName().equals("c")
						&& ((Vertex) e.getDestination()).getName().equals("f")) {
					test.add(e);
					break;
				}
			}

			Assert.assertEquals(test.toArray(), span.toArray());
		}

	}

}
