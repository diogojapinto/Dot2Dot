package mieic.comp.graph;

import mieic.comp.parser.ASTGraph.GraphType;

public class MinimumSpanningTree {

	public static void main(String [] args) throws AttributeAlreadyDefinedException {
		
		Graph g = new Graph("MST", GraphType.GRAPH, false);
		Vertex v0 = new Vertex("v0");
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		g.addVertex(v0);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		Edge e1 = new Edge(v0, v1, GraphType.GRAPH);
		Edge e2 = new Edge(v0, v3, GraphType.GRAPH);
		Edge e3 = new Edge(v3, v2, GraphType.GRAPH);
		Edge e4 = new Edge(v1, v3, GraphType.GRAPH);
		e1.addAttribute("weight", "2");
		e2.addAttribute("weight", "2");
		e3.addAttribute("weight", "2");
		e4.addAttribute("weight", "1");
		
		v0.addEdge(e1);
		v1.addEdge(e1);
		
		v0.addEdge(e2);
		v3.addEdge(e2);
		
		v3.addEdge(e3);
		v2.addEdge(e3);
		
		v1.addEdge(e4);
		v3.addEdge(e4);
		
		System.out.println("MINIMAL COST EXPANSION TREE = " + g.prim("v0"));
	}
}
